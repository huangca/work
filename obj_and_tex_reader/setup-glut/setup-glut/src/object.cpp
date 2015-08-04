
#include <cstring>
#include <fstream>
#include <sstream>
#include <stdio.h>
#include <vector>

// warning: these are POSIX includes so glhf on windows
//#include <sys/types.h>
//#include <regex.h>
//#include <libgen.h>

#include "object.hpp"
#include "globals.hpp"
#include "uniforms.hpp"
#include "debug.hpp"

/*-----------------------------------------------------------------------------
NAMESPACES
------------------------------------------------------------------------------*/
using namespace std;

/*-----------------------------------------------------------------------------
CONSTANTS
------------------------------------------------------------------------------*/
static const vec4 red(255, 0, 0, 1);
static const vec4 green(0, 255, 0, 1);
static const vec4 blue(0, 0, 255, 1);

/*-----------------------------------------------------------------------------
MEMBER STATICS
------------------------------------------------------------------------------*/
int object::current_color_id          = 0;
unsigned int object::texture_cnt      = 0;

struct lighting_scaling ltng = lighting_scaling();

/*-----------------------------------------------------------------------------
MEMBER FUNCTIONS
------------------------------------------------------------------------------*/

//-----------------------------------------------------------------------------
// colored object constructor
colored_object::colored_object(vec4 obj_color)
: color(obj_color)
{
}

//-----------------------------------------------------------------------------
// overloaded draw for colored objects
void
colored_object::draw()
{
	// update flags using custom color
	uni.cc_flag = GL_TRUE;
	uni.cc = this->color;
	uni.update();

	// call parent's version
	object::draw();

	// reset state to what it was before we touched it
	uni.cc_flag = GL_FALSE;
	uni.update();
}

//-----------------------------------------------------------------------------
// composite object constructor
composite_object::composite_object()
{
	// initialize our manipulator
	man.init();
}

//-----------------------------------------------------------------------------
// composite object draw
void
composite_object::draw()
{
	// selection drawing mode prohibits reselection
	if (uni.sel_flag == GL_TRUE) {
		if(this->selected) {
			// only draw manipulators if selected
			man.draw();
		} else {
			// only draw self if not selected
			object::draw();
		}

	// normal drawing mode
	} else {
		// draw parent / self
		object::draw();

		// draw manipulator (only in selection mode)
		if (this->selected) {
			man.draw();
		}
	}
}

//-----------------------------------------------------------------------------
void
manipulator::draw()
{
	x->draw();
	y->draw();
	z->draw();
}

//----------------------------------------------------------------------------
// initialize the manipulator objects
void
manipulator::init()
{
	this->state = MAN_X;

	this->x = new colored_object(red);
	this->x->parse(manipulator_axis_filename);
	this->x->transform *= RotateY(90);
	this->x->transform *= manipulator_axis_scale;

	this->y = new colored_object(green);
	this->y->parse(manipulator_axis_filename);
	this->y->transform *= RotateX(90);
	this->y->transform *= manipulator_axis_scale;

	this->z = new colored_object(blue);
	this->z->parse(manipulator_axis_filename);
	this->z->transform *= manipulator_axis_scale;
}

//-----------------------------------------------------------------------------
void material::parse(string filename)
{
	ifstream file(filename.c_str());
	string line;
	string tag;
	debug_print("material filename: " << filename);

	// dirname implementation, need to get our folder
	size_t found = filename.find_last_of("/\\");
	string dir = filename.substr(0, found);
	dir.append("/");

	debug_print("Parsing material...");
	while(getline(file, line)) {
		if (line == "" || line[0] == '#') {
			continue;
		}

		istringstream line_stream(line);
		line_stream >> tag;

		if (tag == "newmtl") {
			line_stream >> name;
		} else if (tag == "Ka") {
			line_stream >> this->Ka[0];
			line_stream >> this->Ka[1];
			line_stream >> this->Ka[2];
		} else if (tag == "Kd") {
			line_stream >> this->Kd[0];
			line_stream >> this->Kd[1];
			line_stream >> this->Kd[2];
		} else if (tag == "Ks") {
			line_stream >> this->Ks[0];
			line_stream >> this->Ks[1];
			line_stream >> this->Ks[2];
		} else if (tag == "Ns") {
			line_stream >> this->Ns;
		} else if (tag == "Tr" || tag == "d") {
			line_stream >> this->Tr;
		} else if (tag == "map_Ka") {
			this->map_Ka.append(dir);
			string tmp;
			line_stream >> tmp;
			this->map_Ka.append(tmp);
		} else if (tag == "map_Kd") {
			this->map_Kd.append(dir);
			string tmp;
			line_stream >> tmp;
			this->map_Kd.append(tmp);
		} else if (tag == "map_Ks") {
			this->map_Ks.append(dir);
			string tmp;
			line_stream >> tmp;
			this->map_Ka.append(tmp);
		} else if (tag == "map_Ns") {
			this->map_Ns.append(dir);
			string tmp;
			line_stream >> tmp;
			this->map_Ka.append(tmp);
		}
	}

	debug_print("Done parsing material");
}

//-----------------------------------------------------------------------------
// object constructor
object::object()
: color_id(current_color_id++), selected(false), transform(1.0f), texture_enabled(false)
{

}

//-----------------------------------------------------------------------------
// object destructor
object::~object()
{

}

//-----------------------------------------------------------------------------
// add a single texture to the object
void
object::add_texture(string filename)
{
	int x, y, n;

	// set the image to use RGBA even if not configured for it
	unsigned int channels = 4;

	// load the texture as bytes
	debug_print("loading texture through stbi library");
	this->texture = stbi_load(filename.c_str(), &x, &y, &n, channels);
	if (!texture) {
		debug_print("unable to load texture '" << filename << "'");
	}

	// check for texture dimensions being powers of two
	// note: if dim is power of two, it has form 0b10....0, so this
	// operation is 0b10...0 & 0b01...1 = 0 if all is well.
	if (((x & (x - 1)) != 0) || ((y & (y - 1)) != 0)) {
		debug_print("warning: texture '" << filename
		            << "' is not power-of-two in dimensions");
	}

	// need to flip the image right side up!
	unsigned char *upper = NULL;
	unsigned char *lower = NULL;
	unsigned int half_height = static_cast<unsigned int>(y / 2);
	unsigned char tmp = 0;
	unsigned int row_width = x * 4; // RGBA

	debug_print("flipping texture image");
	for (unsigned int row = 0; row < half_height; ++row) {
		upper  = texture + row * row_width;
		lower = texture + (y - row - 1) * row_width;

		for (unsigned int col = 0; col < row_width; ++col) {
			// swap the bytes in upper, lower
			tmp = *upper;
			*upper = *lower;
			*lower = tmp;

			// move on to the next byte
			++upper;
			++lower;
		}
	}

	// copy image data into an OpenGL texture object
	debug_print("creating OpenGL texture object");
	glGenTextures(1, &this->texture_id);

	//texture_slot = GL_TEXTURE0 + this->texture_cnt++;
	//glActiveTexture(texture_slot);
	glActiveTexture(GL_TEXTURE0);
	//glTexEnvf(GL_TEXTURE_ENV, GL_TEXTURE_ENV_MODE, GL_REPLACE);
	
	glBindTexture(GL_TEXTURE_2D, texture_id);
	glTexImage2D(GL_TEXTURE_2D, 0, GL_RGBA, x, y, 0, GL_RGBA,
	             GL_UNSIGNED_BYTE, this->texture);

	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_S, GL_CLAMP_TO_EDGE);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_WRAP_T, GL_CLAMP_TO_EDGE);

	// set to use linear interpolation
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MIN_FILTER, GL_LINEAR);
	glTexParameteri(GL_TEXTURE_2D, GL_TEXTURE_MAG_FILTER, GL_LINEAR);

	this->texture_enabled = true;
	debug_print("completed initializing texture");
}

//-----------------------------------------------------------------------------
// build an object
void
object::build(raw_object raw)
{
	vector<face>::iterator i;

	debug_print("building object... ");

	// map the data in the raw object to the data in the output object
	for (i = raw.faces.begin(); i != raw.faces.end(); ++i) {
		this->points.push_back(raw.vertices[i->v[0]]);
		this->points.push_back(raw.vertices[i->v[1]]);
		this->points.push_back(raw.vertices[i->v[2]]);

		// these are vertex normals, they point away from the vertex
		this->normals.push_back(raw.normals[i->vn[0]]);
		this->normals.push_back(raw.normals[i->vn[1]]);
		this->normals.push_back(raw.normals[i->vn[2]]);

		// these are texture vecticess
		this->texture_vs.push_back(raw.textures[i->vt[0]]);
		this->texture_vs.push_back(raw.textures[i->vt[1]]);
		this->texture_vs.push_back(raw.textures[i->vt[2]]);
	}

	// OpenGL configuration for the data
	size_t points_size = sizeof(this->points[0]) * this->points.size();
	size_t normals_size = sizeof(this->normals[0]) * this->normals.size();
	size_t textures_offst = points_size + normals_size;
	size_t textures_size = sizeof(this->texture_vs[0]) * this->texture_vs.size();

	// Create a vertex array object
	debug_print("creating vertex array... ");
	glGenVertexArrays(1, &this->vao_id);
	glBindVertexArray(this->vao_id);

	debug_print("building buffer object...");
	// set up a buffer object for this vao
	GLuint buffer;
	glGenBuffers(1, &buffer);
	glBindBuffer(GL_ARRAY_BUFFER, buffer);
	glBufferData(GL_ARRAY_BUFFER, points_size + normals_size + textures_size,
	             NULL, GL_DYNAMIC_DRAW);
	glBufferSubData(GL_ARRAY_BUFFER, 0, points_size, this->points.data());
	glBufferSubData(GL_ARRAY_BUFFER, points_size,
	                normals_size, this->normals.data());
	glBufferSubData(GL_ARRAY_BUFFER, textures_offst,
	                textures_size, this->texture_vs.data());

	debug_print("setting up vertex arrays...");
	// set up vertex arrays
	GLuint vPosition = glGetAttribLocation(gl_program, "vPosition");
	glEnableVertexAttribArray(vPosition);
	glVertexAttribPointer(vPosition, 4, GL_FLOAT, GL_FALSE, 0,
	                      BUFFER_OFFSET(0));

	GLuint vNormal = glGetAttribLocation(gl_program, "vNormal");
	glEnableVertexAttribArray(vNormal);
	glVertexAttribPointer(vNormal, 4, GL_FLOAT, GL_FALSE, 0,
	                      BUFFER_OFFSET(points_size));

	GLuint vTexture = glGetAttribLocation(gl_program, "vTexture");
	glEnableVertexAttribArray(vTexture);
	glVertexAttribPointer(vTexture, 2, GL_FLOAT, GL_FALSE, 0,
	                      BUFFER_OFFSET(textures_offst));
}

//----------------------------------------------------------------------------
// draw object (part of callback)
void
object::draw()
{
	debug_print("called object::draw");
	// update uniforms specific to this object
	uni.model = this->transform;
	uni.sel_color = this->color_id;
	uni.update();

	// set draw mode based on if we are selected
	if (this->selected) {
		glPolygonMode(GL_FRONT_AND_BACK, GL_LINE);
		glPolygonOffset(1.0, 2);
	} else {
		glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
	}
	
	// actually draw myself
	glBindVertexArray(this->vao_id);

	if (this->texture_enabled) {
		debug_print("binding texture for object display");
		glEnable(GL_TEXTURE_2D);
		glBindTexture(GL_TEXTURE_2D, this->texture_id);

		// set lighting parameters from material
		uni.ambient_product  = ltng.ambient * light_ambient * this->mat.Ka;
		uni.diffuse_product  = ltng.diffuse * light_diffuse * this->mat.Kd;
		uni.specular_product = ltng.specular * light_specular * this->mat.Ks;

		// TODO add support for illum models

		// Assuming specular coefficient ~ shininess
		uni.material_shine = this->mat.Ns;

		// TODO add support for transparency
		uni.update();
	}

	glDrawArrays(GL_TRIANGLES, 0, this->points.size());

	if (this->texture_enabled) {
		glDisable(GL_TEXTURE_2D);

		// need to reset lighting parameters
		uni.ambient_product = light_ambient * material_ambient;
		uni.diffuse_product = light_diffuse * material_diffuse;
		uni.specular_product = light_specular * material_specular;
		uni.material_shine = material_shininess;
		uni.update();
	}
}

//-----------------------------------------------------------------------------
// parse a file in order to create an object
void
object::parse(string filename)
{
	raw_object dat;
	ifstream file(filename.c_str());
	string line;
	string tag;

	// dirname implementation, need to get our folder
	size_t found = filename.find_last_of("/\\");
	string dir = filename.substr(0, found);
	dir.append("/");

	while(getline(file, line)) {
		if (line == "" || line[0] == '#') {
			continue;
		}

		istringstream line_stream(line);
		line_stream >> tag;

		// geometric vertices
		if (tag == "v") {
			Angel::vec4 element;
			line_stream >> element.x;
			line_stream >> element.y;
			line_stream >> element.z;
			element.w = 1.0f;

			dat.vertices.push_back(element);

		// vertex normal
		} else if (tag == "vn") {
			Angel::vec4 element;
			line_stream >> element.x;
			line_stream >> element.y;
			line_stream >> element.z;
			element.w = 0.0f;

			dat.normals.push_back(element);

		} else if (tag == "vt") {
			Angel::vec2 element;
			line_stream >> element.x;
			line_stream >> element.y;

			dat.textures.push_back(element);

		// face element
		} else if (tag == "f") {
			face f;

			// face layout: <geo vertex>/<texture vertex>/<normal vertex>
			sscanf(line.c_str(),
			       "f %u/%u/%u %u/%u/%u %u/%u/%u",
			       &f.v[0], &f.vt[0], &f.vn[0],
			       &f.v[1], &f.vt[1], &f.vn[1],
			       &f.v[2], &f.vt[2], &f.vn[2]
			       );

			// obj file starts at index 1, vector at index 0
			f.decrement_indices();
			dat.faces.push_back(f);

		// material tag
		} else if (tag == "mtllib") {
			string mtl_filename = dir;
			string tmp;
			line_stream >> tmp;
			mtl_filename.append(tmp);

			this->mat.parse(mtl_filename);
		}

		// TODO add support for subobjects (usemtl, s, g, etc.)
	}

	// hack to get basic textures working
	if (!this->mat.map_Kd.empty()) {
		debug_print("have a valid texture name, so adding texture...");
		this->add_texture(this->mat.map_Kd);
	}

	// implicitly build as part of parsing
	this->build(dat);
}

//-----------------------------------------------------------------------------
// constructor for a group of objects
objects::objects()
: selected(NULL)
{
}

//-----------------------------------------------------------------------------
// destructor for global group of objects
objects::~objects()
{
	vector<composite_object *>::iterator i;

	for (i = data.begin(); i != data.end(); ++i) {
		delete *i;
	}
}

//-----------------------------------------------------------------------------
// add a new object to myself
void objects::add_new(string filename)
{
	composite_object *pointer = new composite_object();
	pointer->parse(filename);

	data.push_back(pointer);
}

//-----------------------------------------------------------------------------
// add a new object to myself (built by someone else)
void objects::add_new(composite_object *pre_built)
{
	data.push_back(pre_built);
}

//-----------------------------------------------------------------------------
// draw all of my objects
void objects::draw()
{
	vector<composite_object *>::iterator i;

	for (i = data.begin(); i != data.end(); ++i) {
		if (*i != NULL) {
			(*i)->draw();
		}
	}
}

//-----------------------------------------------------------------------------
void objects::deselect()
{
	vector<composite_object *>::iterator i;
	for (i = data.begin(); i != data.end(); ++i) {
		(*i)->selected = false;
	}

}


void objects::clear()
{

	data.clear();


}


//-----------------------------------------------------------------------------
// determine if we selected one of my objects
composite_object * objects::select(GLubyte color_id)
{
	vector<composite_object *>::iterator i;

	for (i = data.begin(); i != data.end(); ++i) {
		manipulator *man = &(*i)->man;
		(*i)->selected = false;

		// was the actual object selected?
		if (ceil((*i)->color_id) == ceil(color_id)) {
			debug_print("selected a new object");
			selected = *i;

		// was the manipulator selected?
		// X manipulator
		} else if (ceil(man->x->color_id) == ceil(color_id)) {
			man->state = MAN_X;
		// Y manipulator
		} else if (ceil(man->y->color_id) == ceil(color_id)) {
			man->state = MAN_Y;
		// Z manipulator
		} else if (ceil(man->z->color_id) == ceil(color_id)) {
			man->state = MAN_Z;
		} else {
		// reset manipulator status
		man->state = MAN_NOT_SELECTED;
		}
	}

	if (selected != NULL) {
		// toggle selected status
		selected->selected = true;
	}

	return this->selected;
}