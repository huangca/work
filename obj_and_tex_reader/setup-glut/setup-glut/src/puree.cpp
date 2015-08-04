
#define GL3_PROTOTYPES

/*------------------------------------------------------------------------------
STL INCLUDES
------------------------------------------------------------------------------*/
#include <cstring>
#include <exception>
#include <stdio.h>
#include <vector>

/*------------------------------------------------------------------------------
THIRD PARTY INCLUDES
------------------------------------------------------------------------------*/
//#include <SFML/Graphics.hpp>
//#include <SFML/OpenGL.hpp>

/*------------------------------------------------------------------------------
LOCAL INCLUDES
------------------------------------------------------------------------------*/
#include "../include/Angel.h"
#include "puree.hpp"
#include "globals.hpp"
#include "uniforms.hpp"
#include "object.hpp"
#include "debug.hpp"

/*------------------------------------------------------------------------------
NAMESPACE SELECTION
------------------------------------------------------------------------------*/
using namespace std;

/*------------------------------------------------------------------------------
CONSTANTS
------------------------------------------------------------------------------*/
static const float x_scale     = .010f;
static const float y_scale     = .010f;
static const float scene_scale = 2.5f;

/*------------------------------------------------------------------------------
ENUMS
------------------------------------------------------------------------------*/
enum menu_entries {
	LOAD_OBJ,

	LOAD_CUBE,
	LOAD_CA,
	LOAD_SP,


	TOGGLE_TOON,
	SET_TOON_SHADES,

	OBJ_TRANSLATION,
	OBJ_ROTATION,
	OBJ_SCALE,

	LTNG_AMBIENT,
	LTNG_DIFFUSE,
	LTNG_SPECULAR,

	SCN_X_ROTATION,
	SCN_Y_ROTATION,
	SCN_Z_ROTATION,
	SCN_TRANSLATION,
	SCN_DOLLY,

	TOGGLE_DEBUG,

	QUIT,

	SWITCH,

	CLEAR,

	NO_ACTION
};

/*------------------------------------------------------------------------------
CUSTOM TYPES
------------------------------------------------------------------------------*/
struct camera_transforms {

	// provide constructor that initializes all to identity matrix
	camera_transforms()
		: translate(1.0f), theta_x(0.0f), theta_y(0.0f), theta_z(0.0f)
		{};

	mat4 calculate_view(){
		return translate * RotateX(theta_x) * RotateY(theta_y) * RotateZ(theta_z);
	};

	mat4      translate;
	float     theta_x;
	float     theta_y;
	float     theta_z;
};

struct mouse_data {
	mouse_data()
	: down(false), last_x(-1), last_y(-1)
	{};

	bool      down;                  // is the mouse currently down?
	int       last_x;                // last x position
	int       last_y;                // last y position
};

/*------------------------------------------------------------------------------
GLOBAL VARIABLES
------------------------------------------------------------------------------*/
objects                data;

camera_transforms      ct;

GLuint                 gl_program;

mouse_data             mouse = mouse_data();

opengl_uniforms        uni;

int                    menu_state = SCN_DOLLY;
int                    last_menu_state = menu_state;

bool                   debug_output = false;

/*------------------------------------------------------------------------------
FUNCTIONS
------------------------------------------------------------------------------*/

//----------------------------------------------------------------------------
// callback function
void
callback_menu(int value)
{
	debug_print("Processing menu selection, ID = " << value);

	// simple passthrough to update state
	last_menu_state = menu_state;
	menu_state = value;

	// call handle_menu_req to update state stuff
	handle_menu_req(0, 0);
}

//----------------------------------------------------------------------------
// Create GLUT menu
int
create_menu()
{
	int obj_menu = glutCreateMenu(callback_menu);
	glutAddMenuEntry("Translation", OBJ_TRANSLATION);
	glutAddMenuEntry("Rotation", OBJ_ROTATION);
	glutAddMenuEntry("Scale", OBJ_SCALE);

	int loj_menu=glutCreateMenu(callback_menu);
	glutAddMenuEntry("load cube",LOAD_CUBE);
	glutAddMenuEntry("load capsule",LOAD_CA);
	glutAddMenuEntry("load sphere",LOAD_SP);


	int ltng_menu = glutCreateMenu(callback_menu);
	glutAddMenuEntry("Ambient factor", LTNG_AMBIENT);
	glutAddMenuEntry("Diffuse factor", LTNG_DIFFUSE);
	glutAddMenuEntry("Specular factor", LTNG_SPECULAR);

	int rot_menu = glutCreateMenu(callback_menu);
	glutAddMenuEntry("X", SCN_X_ROTATION);
	glutAddMenuEntry("Y", SCN_Y_ROTATION);
	glutAddMenuEntry("Z", SCN_Z_ROTATION);

	int scn_menu = glutCreateMenu(callback_menu);
	glutAddSubMenu("Rotation", rot_menu);
	glutAddMenuEntry("Translation", SCN_TRANSLATION);
	glutAddMenuEntry("Dolly", SCN_DOLLY);

	//int shader_menu = glutCreateMenu(callback_menu);
	//glutAddMenuEntry("Toggle Cel Shader On/Off", TOGGLE_TOON);
	//glutAddMenuEntry("Set Cel Shades Count", SET_TOON_SHADES);

	int main_menu = glutCreateMenu(callback_menu);
	glutAddSubMenu("Scene Commands", scn_menu);
	glutAddSubMenu("Lighting Commands", ltng_menu);
	glutAddSubMenu("Load New Object", loj_menu);
	//glutAddSubMenu("Shader Commands", shader_menu);
	//glutAddSubMenu("Object Commands", obj_menu);

	//glutAddMenuEntry("Toggle Debug Output", TOGGLE_DEBUG);
	glutAddMenuEntry("switch", SWITCH);
	glutAddMenuEntry("clear",CLEAR);
	glutAttachMenu(GLUT_RIGHT_BUTTON);

	return (main_menu);
}

//----------------------------------------------------------------------------
void
display_cb(void)
{
	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	uni.view = ct.calculate_view();
	uni.sel_flag = GL_FALSE;
	uni.update();
	data.draw();

	// comment to see the color render
	glutSwapBuffers();
}

//----------------------------------------------------------------------------
bool
handle_object_transform(int x_delta, int y_delta)
{
	switch(menu_state) {
	case OBJ_TRANSLATION: {
		if (data.selected == NULL) return false;
		debug_print("handling request for object translation");
		int row_x = -1;
		int row_y = -1;

		// do translations like blender, i.e. selected axis restrictive
		switch(data.selected->man.state) {
		case MAN_X:
			row_x = 1;
			row_y = 2;
			break;
		case MAN_Y:
			row_x = 0;
			row_y = 2;
			break;
		case MAN_Z:
			row_x = 0;
			row_y = 1;
			break;
		case MAN_NOT_SELECTED:
			debug_print("valid manipulator has not been selected");
			return false;
		default:
			cout << "Error: no valid manipulator state!" << endl;
			return false;
		}

		data.selected->transform[row_x][3] += x_delta * x_scale;
		data.selected->transform[row_y][3] -= y_delta * y_scale;

		data.selected->man.x->transform[row_x][3] += x_delta * x_scale;
		data.selected->man.x->transform[row_y][3] -= y_delta * y_scale;

		data.selected->man.y->transform[row_x][3] += x_delta * x_scale;
		data.selected->man.y->transform[row_y][3] -= y_delta * y_scale;

		data.selected->man.z->transform[row_x][3] += x_delta * x_scale;
		data.selected->man.z->transform[row_y][3] -= y_delta * y_scale;
		}
		break;

	case OBJ_ROTATION:
		switch(data.selected->man.state) {
		case MAN_X:
			if (data.selected == NULL) return false;
			debug_print("handling request for object x rotation");
			data.selected->transform *= RotateX(x_delta);
			break;

		case MAN_Y:
			if (data.selected == NULL) return false;
			debug_print("handling request for object y rotation");
			data.selected->transform *= RotateY(x_delta);
			break;

		case MAN_Z:
			if (data.selected == NULL) return false;
			debug_print("handling request for object z rotation");
			data.selected->transform *= RotateZ(x_delta);
			break;

		case MAN_NOT_SELECTED:
			debug_print("valid manipulator has not been selected");
			return false;
		default:
			cout << "Error: no valid manipulator state!" << endl;
			return false;
		}
		break;

	case OBJ_SCALE: {
		if (data.selected == NULL) return false;

		debug_print("handling request for object scaling");
		float s = (1 + x_delta * x_scale);
		debug_print("scaling obj with factor: " << s);

		switch(data.selected->man.state) {
		case MAN_X:
			debug_print("scaling object in X direction");
			data.selected->transform *= Scale(s, 1, 1);
			break;
		case MAN_Y:
			debug_print("scaling object in Y direction");
			data.selected->transform *= Scale(1, s, 1);
			break;
		case MAN_Z:
			debug_print("scaling object in Z direction");
			data.selected->transform *= Scale(1, 1, s);
			break;
		case MAN_NOT_SELECTED:
			debug_print("Valid manipulator has not been selected");
			return false;
		default:
			cout << "Error: no valid manipulator state!" << endl;
			return false;
		}
		}
		break;
	default:
		return false;
	}

	// return true if we handled it
	return true;
}

//----------------------------------------------------------------------------
bool
handle_scene_transform(int x_delta, int y_delta)
{
	vec4 mouse_move(x_delta, y_delta, 0.0f, 0.0f);
	vec4 scene_move = normalize(uni.view * mouse_move);

	switch(menu_state) {
	case SCN_X_ROTATION:
		debug_print("handling request for scene x rotation, theta = "
		            << ct.theta_x);
		ct.theta_x += (x_delta > 0) ? scene_scale : -scene_scale;
		break;

	case SCN_Y_ROTATION:
		debug_print("handling request for scene y rotation, theta = "
		            << ct.theta_y);
		ct.theta_y += (x_delta > 0) ? scene_scale : -scene_scale;
		break;

	case SCN_Z_ROTATION:
		debug_print("handling request for scene z rotation, theta = "
		            << ct.theta_z);
		ct.theta_z += (x_delta > 0) ? scene_scale : -scene_scale;
		break;

	case SCN_TRANSLATION:
		debug_print("handling request for scene translation");
		{
		float delta = (scene_move.x > 0) ? .05 : -.05;
		vec4 plane = uni.view * vec4(0, 0, 0, 1);
		plane.w = 0;
		plane = normalize(cross(plane, vec4(0, 1, 0, 0)));
		plane.w = 0;

		float delta_x = delta * dot(plane, vec4(1, 0, 0, 0));
		float delta_y = delta * dot(plane, vec4(0, 1, 0, 0));
		float delta_z = delta * dot(plane, vec4(0, 0, 1, 0));

		ct.translate *= Translate(delta_x, delta_y, delta_z);
		}
		break;

	case SCN_DOLLY:
		debug_print("handling request for scene dolly");
		{
		float delta = (scene_move.x > 0) ? .05 : -.05;
		vec4 plane = uni.view * vec4(0, 0, 0, 1);
		plane.w = 0;
		plane = normalize(plane);

		float delta_x = delta * dot(plane, vec4(1, 0, 0, 0));
		float delta_y = delta * dot(plane, vec4(0, 1, 0, 0));
		float delta_z = delta * dot(plane, vec4(0, 0, 1, 0));

		ct.translate *= Translate(delta_x, delta_y, delta_z);
		}
		break;

	default:
		return false;
	}

	// return true if we handled it
	return true;
}

//----------------------------------------------------------------------------
bool
handle_cel_req(int x_delta, int y_delta)
{
	switch(menu_state) {
	case TOGGLE_TOON:
		// explicitly toggle
		if (uni.cel_flag == GL_TRUE) {
			cout << "Toggled cel shader OFF" << endl;
			uni.cel_flag = GL_FALSE;
		} else {
			cout << "Toggled cel shader ON" << endl;
			uni.cel_flag = GL_TRUE;
		}
		uni.update();
		break;

	case SET_TOON_SHADES:
		cout << "Please enter the number of shades desired:" << endl;
		int shade_cnt;
		cin >> shade_cnt;

		uni.cel_shades = shade_cnt;
		uni.update();
		display_cb();
		break;

	default:
		return false;
	}

	return true;
}

//----------------------------------------------------------------------------
void
prompt_for_object()
{
	string filename;

	cout << "Please enter a valid filename:" << endl;
	cin >> filename;
	data.add_new(filename);
}

bool
handle_ltng_req(int x_delta, int y_delta)
{
	float inc = 0.1f;

	switch(menu_state) {
	case LTNG_AMBIENT:
		if (x_delta > 0) {
			ltng.ambient += inc;
			// don't rollover
			if (ltng.ambient > 1.0f) {
				ltng.ambient = 1.0f;
			}
		} else {
			ltng.ambient -= inc;
			// don't rollover
			if (ltng.ambient < 0.0f) {
				ltng.ambient = 0.0f;
			}
		}
		break;
	case LTNG_DIFFUSE:
		if (x_delta > 0) {
			ltng.diffuse += inc;
			// don't rollover
			if (ltng.diffuse > 1.0f) {
				ltng.diffuse = 1.0f;
			}
		} else {
			ltng.diffuse -= inc;
			// don't rollover
			if (ltng.diffuse < 0.0f) {
				ltng.diffuse = 0.0f;
			}
		}
		break;
	case LTNG_SPECULAR:
		if (x_delta > 0) {
			ltng.specular += inc;
			// don't rollover
			if (ltng.specular > 1.0f) {
				ltng.specular = 1.0f;
			}
		} else {
			ltng.specular -= inc;
			// don't rollover
			if (ltng.specular < 0.0f) {
				ltng.specular = 0.0f;
			}
		}
		break;
	default:
		return false;
	}

	return true;
}

//----------------------------------------------------------------------------
// note that this assumes operations done on the currently selected obj
bool
handle_menu_req(int x_delta, int y_delta)
{
	switch(menu_state) {
	// need an option to load an object
	case LOAD_OBJ: {
		prompt_for_object();
		menu_state = last_menu_state;
		}
		break;
	
	case LOAD_CUBE:{
				  				  
				  data.add_new("cube/cube.obj");
				  menu_state = NO_ACTION;
				  
				  }
				  break;

	case LOAD_CA:{
				  				  
				  data.add_new("objs/capsule/capsule.obj");
				  menu_state = NO_ACTION;
				  
				  }
				  break;



		case LOAD_SP:{
				  				  
				  data.add_new("cube_sphere_test/cube_sphere_test.obj");
				  menu_state = NO_ACTION;
				  
				  }
				  break;

		case SWITCH:{

			if (uni.test_flag == GL_TRUE) {
			cout << "switch off" << endl;
			uni.test_flag = GL_FALSE;
		} else {
			cout << "switch on" << endl;
			uni.test_flag = GL_TRUE;
		}
		uni.update();
		}
		break;
					
					
		case CLEAR:{
					
			data.clear();
		
		uni.update();
		}
		break;

	case TOGGLE_DEBUG:
		debug_output = !debug_output;
		cout << "Turned debug output "
		     << (debug_output ? "ON" : "OFF") << endl;
		menu_state = last_menu_state;
		break;

	case NO_ACTION:
		break;

	case QUIT:
		cout << "Exiting application..." << endl;
		exit(0);
		break;

	default:
		if (handle_object_transform(x_delta, y_delta)) {
		} else if(handle_ltng_req(x_delta, y_delta)) {
		} else if(handle_scene_transform(x_delta, y_delta)) {
		} else if (handle_cel_req(x_delta, y_delta)) {
			// cel requests are one time only
			menu_state = last_menu_state;
		} else {
			debug_print("unable to handle request");
			return false;
		}
	}

	display_cb();
	return true;
}


//----------------------------------------------------------------------------
// OpenGL initialization
void
init()
{
	// Load shaders and use the resulting shader program
	gl_program = InitShader("vshader.glsl", "fshader.glsl");
	glUseProgram(gl_program);

	// initialize uniform variables

	// needs to be done here? why?
	uni.light_position = light_position;
	uni.init_locs();

	glEnable(GL_DEPTH_TEST);
	//glShadeModel(GL_FLAT);
	glClearColor(0.5f, 0.5f, 0.5f, 0.0);
}

//----------------------------------------------------------------------------
void
keyboard_cb(unsigned char key, int x, int y)
{
	switch(key) {
	case 033:  // Escape key
	case 'q': case 'Q':
		exit(EXIT_SUCCESS);
		break;
	}
}

//----------------------------------------------------------------------------
void
mouse_click_cb(int button, int state, int x, int y)
{
	vector<object>::iterator i;

	// don't care about right clicks (they go to menu)
	if (button != GLUT_LEFT_BUTTON) {
		return;
	}

	// mouse click MAY be part of a drag operation
	if (state == GLUT_DOWN) {
		mouse.down = true;
		mouse.last_x = x;
		mouse.last_y = y;
	} else {
		mouse.down = false;
		return;
	}

	glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

	// render objects using selection color
	//uni.sel_flag = GL_TRUE;
	//uni.view = ct.calculate_view();
	//uni.update();
	//data.draw();

	//// no longer render objects using selection color
	//uni.sel_flag = GL_FALSE;
	//uni.update();

	// check the pixel location
	GLubyte pixel;
	GLint viewport[4];
	glGetIntegerv(GL_VIEWPORT, viewport);

	// read as an unsigned byte
	glReadPixels(x, viewport[3] - y, 1, 1, GL_RED, GL_UNSIGNED_BYTE, &pixel);

	// get selection
	data.select(pixel);

	// uncomment to see the color render
	//glutSwapBuffers();

	display_cb();
}

//----------------------------------------------------------------------------
void mouse_drag_cb(int x, int y)
{
	// we are only dragging if the mouse is clicked currently
	if (mouse.down) {
		handle_menu_req(x - mouse.last_x, y - mouse.last_y);
	}

	// only care about what has happened since the last time we changed
	mouse.last_x = x;
	mouse.last_y = y;
}

//----------------------------------------------------------------------------
// reshaping callback
void reshape_cb(int w, int h)
{
	float window_ratio = static_cast<float>(w) / static_cast<float>(h);
	uni.proj = Perspective(90, window_ratio, 0.01, 100.0);
	uni.update();
	glViewport(0, 0, w, h);
}

//----------------------------------------------------------------------------
void handle_args(int argc, char **argv)
{
	Angel::vec4 from(0, 1, 3, 0);
	Angel::vec4   at(0, 0, 0, 0);
	Angel::vec4   up(0, 1, 0, 0);

	// keep track of camera translations
	ct.translate = Translate(-from);

	if (strcmp(argv[1], "-p") == 0) {
		debug_print("using perspective syntax");
		if (argc < 5) {
			cout << "Error: insufficient arguments provided." << endl;
			usage();
		}

		// change to our custom view
		uni.view = LookAt(from, at, up);
		uni.proj = Perspective(atof(argv[2]), 1.0f, atof(argv[3]), atof(argv[4]));

	} else if (strcmp(argv[1], "-o") == 0) {
		debug_print("using ortho syntax");

		if (argc < 8) {
			cout << "Error: insufficient arguments provided." << endl;
			usage();
		}
		uni.view = LookAt(from, at, up);
		uni.proj = Ortho(atof(argv[2]), atof(argv[3]), atof(argv[4]),
		                 atof(argv[5]), atof(argv[6]), atof(argv[7]));

	} else if (strcmp(argv[1], "-h") == 0) {
		cout << "Error: was unable to parse arguments" << endl;
		usage();
	}
}

void usage()
{
	// command line syntax
	// P fov near far
	// alternatively
	// O left right bottom top near far

cout << "This program accepts two methods of setting the camera:" << endl;
cout << "\t -p <fov> <near> <far>" << endl;
cout << "\t -o <left> <right> <bottom> <near> <far>" << endl;
cout << "Note that both methods have all input values as float types" << endl;
cout << "To display this usage prompt:" << endl;
cout << "\t -h" << endl;
}

//----------------------------------------------------------------------------
// main program, initializes objects and handles main program loop
int main(int argc, char** argv)
{
	handle_args(argc, argv);

	// glut initialization
	debug_print("Handling glut initialization");
	glutInit(&argc, argv);
	glutInitDisplayMode(GLUT_RGBA | GLUT_DOUBLE);
	glutInitWindowSize(512, 512);
	glutInitWindowPosition(600, 100);
	glutCreateWindow("3D Object Loader");

	// print information about the current GL connection
	cout << endl << "Renderer: " << glGetString(GL_RENDERER) << endl;
	cout << "OpenGL Version: " << glGetString(GL_VERSION) << endl;
	cout << "Shading Language Version: " << 
	        glGetString(GL_SHADING_LANGUAGE_VERSION) << endl;

	// GLEW initialization
	glewExperimental = GL_TRUE;
	glewInit();

	create_menu();
	debug_print("Created menu");

	init();
	debug_print("Initialized OpenGL");

	//data.add_new("objs/capsule/capsule.obj");
	//data.add_new("cube/Crate1.obj");
	

	// callbacks; must go after window creation
	glutDisplayFunc    (display_cb);
	glutKeyboardFunc   (keyboard_cb);
	glutMouseFunc      (mouse_click_cb);
	glutMotionFunc     (mouse_drag_cb);
	glutReshapeFunc    (reshape_cb);

	glutMainLoop();

	debug_print("Exited main loop");
	return(0);
}