
#ifndef OBJECT_HPP
#define OBJECT_HPP

/*------------------------------------------------------------------------------
INCLUDES
------------------------------------------------------------------------------*/
#include <vector>
#include <cstring>
#include <stdio.h>
#include <exception>

#include "../include/Angel.h"

#include "stb_image.h"

/*------------------------------------------------------------------------------
NAMESPACES
------------------------------------------------------------------------------*/
using namespace std;
using namespace Angel;

/*------------------------------------------------------------------------------
CONSTANTS
------------------------------------------------------------------------------*/
// the manipulator uses an object file and manipulates it for each axis
static const string manipulator_axis_filename = string("objs/arrow2.obj");
static const mat4   manipulator_axis_scale = Scale(0.2f, 0.2f, 1.5f);

/*------------------------------------------------------------------------------
ENUMS
------------------------------------------------------------------------------*/
enum manipulator_modes {
	MAN_NOT_SELECTED,
	MAN_X,
	MAN_Y,
	MAN_Z
};

/*------------------------------------------------------------------------------
Lighting scaling type
------------------------------------------------------------------------------*/
struct lighting_scaling {
	lighting_scaling(float a, float d, float s)
	: ambient(a), diffuse(d), specular(s)
	{
	};

	lighting_scaling()
	: ambient(0.5f), diffuse(0.5f), specular(0.5f)
	{
	};

	float     ambient;
	float     diffuse;
	float     specular;
};
extern struct lighting_scaling ltng;

/*------------------------------------------------------------------------------
MTL material type
------------------------------------------------------------------------------*/
class material {
public:
	string name;      // material name
	vec4  Ka;         // ambient color
	vec4  Kd;         // diffuse color
	vec4  Ks;         // specular color
	short illum;      // illumination model to use (0 - 10)
	float Ns;         // specular coefficient
	float Tr;         // dissolved / transparent (d or Tr) value

	/*----------------------------------------------------------------------
	Texture maps (these will need to be parsed individually)
	----------------------------------------------------------------------*/
	string map_Ka;    // ambient texture map
	string map_Kd;    // diffuse texture map (typically same as ambient)
	string map_Ks;    // specular color texture map
	string map_Ns;    // specular highlight component
	string map_d;     // alpha texture map

	string bump;      // bump map (uses luminance channel of image)
	string disp;      // displacement map
	string decal;     // stencil decal texture
	string refl;      // reflection map

	// parse an MTL file
	void parse(string filename);
};


/*------------------------------------------------------------------------------
Face class
------------------------------------------------------------------------------*/
struct face {
	face(GLuint v1, GLuint vt1, GLuint vn1,
	     GLuint v2, GLuint vt2, GLuint vn2,
	     GLuint v3, GLuint vt3, GLuint vn3)
	{
	 v[0] =  v1;  v[1] =  v2;  v[2] =  v3;
	vn[0] = vn1; vn[1] = vn2; vn[2] = vn3;
	vt[0] = vt1; vt[1] = vt2; vt[2] = vt3;
	};

	face()
	{
	 v[0] = 0;  v[1] = 0;  v[2] = 0;
	vn[0] = 0; vn[1] = 0; vn[2] = 0;
	vt[0] = 0; vt[1] = 0; vt[2] = 0;
	};

	void decrement_indices()
	{--v[0];  --v[1];  --v[2];
	--vt[0]; --vt[1]; --vt[2];
	--vn[0]; --vn[1]; --vn[2];};

	GLuint v [3];
	GLuint vt[3];
	GLuint vn[3];
};

/*------------------------------------------------------------------------------
Raw object (used solely during processing)
------------------------------------------------------------------------------*/
class raw_object {
public:
	vector<vec4> vertices;         // v tag
	vector<vec4> normals;          // vn tag
	vector<vec2> textures;         // vt tag

	vector<face> faces;            // f tag
};

/*------------------------------------------------------------------------------
Completed object class
------------------------------------------------------------------------------*/
class object {
public:
	object();
	virtual ~object();

	// declare virtual so that we can call overridden versions
	virtual void draw();

	void parse(string filename);

	GLubyte             color_id; // red element used as id
	vector<vec4>        normals;
	vector<vec4>        points;
	vector<vec2>        texture_vs;
	bool                selected;
	mat4                transform;
	GLuint              vao_id;

	static int          current_color_id;

private:
	unsigned char      *texture;
	GLuint              texture_id;
	bool                texture_enabled;

	// keep track of texture count and assign to slots
	static unsigned int texture_cnt;
	unsigned int        texture_slot;

	material            mat;

	void add_texture(string filename);
	void build(raw_object raw);
};

/*------------------------------------------------------------------------------
Object with singular, custom color
------------------------------------------------------------------------------*/
class colored_object : public object {
public:
	colored_object(vec4 obj_color = vec4(0, 0, 0, 0));

	void draw();

private:
	vec4                color;
};

/*------------------------------------------------------------------------------
Manipulator object (special group of objects)
------------------------------------------------------------------------------*/
class manipulator {
public:
	manipulator() : state(MAN_NOT_SELECTED)
	{};

	void draw();
	void init();

	colored_object *x;
	colored_object *y;
	colored_object *z;
	manipulator_modes state;
};

/*------------------------------------------------------------------------------
Composite object (object plus things it needs)
------------------------------------------------------------------------------*/
class composite_object : public object {
public:
	composite_object();
	composite_object(string obj_filename);

	void draw();

	void parse_mtl(string mtl_filename);
	void parse_obj(string obj_filename);

	material    mat;
	manipulator man;
};

/*------------------------------------------------------------------------------
Container class for handling groups of objects
------------------------------------------------------------------------------*/
class objects {
public:
	objects();
	~objects();

	void add_new(string filename);

	// allow the user to register an existing object (assumes new'd, built)
	void add_new(composite_object *pre_built);

	void draw();

	composite_object * select(GLubyte color_id);
	void deselect();

	composite_object             *selected;

	void clear();

private:
	vector<composite_object *>    data;
};

#endif