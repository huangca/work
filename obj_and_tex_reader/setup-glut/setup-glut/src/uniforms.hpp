
#ifndef UNIFORMS_HPP
#define UNIFORMS_HPP

/*------------------------------------------------------------------------------
INCLUDES
------------------------------------------------------------------------------*/
#include "../include/Angel.h"

/*------------------------------------------------------------------------------
UNIFORMS CONFIGURATION CONSTANTS
------------------------------------------------------------------------------*/
static const vec4  light_position   (0.0, 2.0, 2.0, 1.0);

static const vec4  light_ambient    (1.0, 1.0, 1.0, 1.0);
static const vec4  light_diffuse    (0.5, 0.5, 0.5, 1.0);
static const vec4  light_specular   (0.8, 0.8, 0.8, 1.0);

static const vec4  material_ambient (0.7, 0.2, 0.2, 1.0);
static const vec4  material_diffuse (0.8, 0.1, 0.1, 1.0);
static const vec4  material_specular(0.7, 0.3, 0.3, 1.0);

static const float material_shininess = 4;

/*------------------------------------------------------------------------------
CLASSES
------------------------------------------------------------------------------*/
class opengl_uniforms {
public:
	opengl_uniforms()
	: cc_flag(GL_FALSE), sel_color(0), sel_flag(GL_FALSE)
	{};

	void init_locs();
	void update();

	/*----------------------------------------------------------------------
	Lighting parameters
	----------------------------------------------------------------------*/
	vec4      ambient_product;       // ambient product
	GLuint    ambient_product_loc;   // ambient product (location)
	vec4      diffuse_product;       // diffuse product
	GLuint    diffuse_product_loc;   // diffuse product (location)
	vec4      specular_product;      // specular product
	GLuint    specular_product_loc;  // specular product (location)
	vec4      light_position;        // light position
	GLuint    light_position_loc;    // light position (location)
	GLfloat   material_shine;        // material shininess
	GLuint    material_shine_loc;    // material shininess (location)

	/*----------------------------------------------------------------------
	Custom color parameters
	----------------------------------------------------------------------*/
	vec4      cc;                    // custom color
	GLuint    cc_loc;                // custom color (location)
	GLboolean cc_flag;               // custom color enabled
	GLuint    cc_flag_loc;           // custom color enabled (location)

	/*----------------------------------------------------------------------
	Camera / view parameters
	----------------------------------------------------------------------*/
	mat4      model;                 // model matrix
	GLuint    model_loc;             // model matrix (location)
	mat4      proj;                  // projection matrix
	GLuint    proj_loc;              // projection matrix (location)
	mat4      view;                  // view matrix
	GLuint    view_loc;              // view matrix (location)

	/*----------------------------------------------------------------------
	Cel shader parameters
	----------------------------------------------------------------------*/
	GLboolean cel_flag;              // toggle the cel shader
	GLuint    cel_flag_loc;          // toggle the cel shader (location)
	GLint     cel_shades;            // number of cel shades
	GLuint    cel_shades_loc ;       // number of cel shades (location)

	/*----------------------------------------------------------------------
	Selection parameters
	----------------------------------------------------------------------*/
	GLubyte   sel_color;             // selection color
	GLuint    sel_color_loc;         // selection color (location)
	GLboolean sel_flag;              // selection flag
	GLuint    sel_flag_loc;          // selection flag (location)

	//---------------------------------------------------------------
	GLboolean test_flag;             //
	GLuint    test_flag_loc;

};

#endif
