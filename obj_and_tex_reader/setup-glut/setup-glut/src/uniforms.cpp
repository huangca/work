

/*------------------------------------------------------------------------------
LOCAL INCLUDES
------------------------------------------------------------------------------*/
#include "uniforms.hpp"
#include "globals.hpp"

/*------------------------------------------------------------------------------
MEMBER FUNCTIONS
------------------------------------------------------------------------------*/

//----------------------------------------------------------------------------
// initialize the set of uniforms
void opengl_uniforms::init_locs()
{

	// Initialize shader lighting parameters
	this->ambient_product  = light_ambient * material_ambient;
	ambient_product_loc    = glGetUniformLocation(gl_program, "AmbientProduct");

	this->diffuse_product  = light_diffuse * material_diffuse;
	diffuse_product_loc    = glGetUniformLocation(gl_program, "DiffuseProduct");

	this->specular_product = light_specular * material_specular;
	specular_product_loc   = glGetUniformLocation(gl_program, "SpecularProduct");

	this->light_position   = light_position;
	light_position_loc     = glGetUniformLocation(gl_program, "LightPosition");

	this->material_shine   = material_shininess;
	material_shine_loc     = glGetUniformLocation(gl_program, "Shininess");

	// cel shader setup
	this->cel_flag         = GL_FALSE;
	cel_flag_loc           = glGetUniformLocation(gl_program, "cel_flag");

	this->cel_shades       = 4;
	cel_shades_loc         = glGetUniformLocation(gl_program, "cel_shades");

	// set up the selection colors, flag
	sel_color_loc          = glGetUniformLocation(gl_program, "sel_color");
	this->sel_flag         = GL_FALSE;
	sel_flag_loc           = glGetUniformLocation(gl_program, "sel_flag");

	// set up the custom color stuff
	cc_loc                 = glGetUniformLocation(gl_program, "cc");
	this->cc_flag          = GL_FALSE;
	cc_flag_loc            = glGetUniformLocation(gl_program, "cc_flag");

	// transformation variable locations
	model_loc              = glGetUniformLocation(gl_program, "Model");
	view_loc               = glGetUniformLocation(gl_program, "View");
	proj_loc               = glGetUniformLocation(gl_program, "Projection");

	this->test_flag        =GL_FALSE;
	test_flag_loc		   = glGetUniformLocation(gl_program, "test_flag");


	this->update();
}

//----------------------------------------------------------------------------
// update uniforms to shader
void opengl_uniforms::update()
{
		glUniform4f(cc_loc, cc[0], cc[1], cc[2], cc[3]);
		glUniform1i(cc_flag_loc, cc_flag);

		glUniformMatrix4fv(model_loc, 1, GL_TRUE, model);
		glUniformMatrix4fv(proj_loc, 1, GL_TRUE, proj);
		glUniformMatrix4fv(view_loc, 1, GL_TRUE, view);

		glUniform1i(cel_flag_loc, cel_flag);
		glUniform1i(cel_shades_loc, cel_shades);
		glUniform1i(sel_color_loc, sel_color);
		glUniform1i(sel_flag_loc, sel_flag);

		glUniform1i(test_flag_loc,test_flag);

		glUniform4fv(ambient_product_loc, 1, ambient_product);
		glUniform4fv(diffuse_product_loc, 1, diffuse_product);
		glUniform4fv(specular_product_loc, 1, specular_product);
		glUniform4fv(light_position_loc, 1, light_position);
		glUniform1f(material_shine_loc, material_shine);
}

