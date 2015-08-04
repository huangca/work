
#ifndef GLOBALS_HPP
#define GLOBALS_HPP

#include "../include/Angel.h"

/*------------------------------------------------------------------------------
EXTERNS
------------------------------------------------------------------------------*/
extern class objects             data;

extern class composite_object   *selected_obj;

extern int                       menu_state;

extern int                       last_menu_state;

// OpenGL program instance
extern GLuint                    gl_program;

// camera transformation matrices
extern struct camera_transforms  ct;

// object manipulator
extern struct manipulator        man;

// mouse information
extern struct mouse_data         mouse;

// opengl uniform variables
extern struct opengl_uniforms    uni;

extern bool                      debug_output;

#endif