
#ifndef PUREE_HPP
#define PUREE_HPP

using namespace std;

/*------------------------------------------------------------------------------
SYSTEM INCLUDES
------------------------------------------------------------------------------*/
#include <cstring>
#include <exception>
#include <fstream>
#include <sstream>
#include <stdio.h>

/*------------------------------------------------------------------------------
LOCAL INCLUDES
------------------------------------------------------------------------------*/
#include "../include/Angel.h"
#include "object.hpp"
#include "uniforms.hpp"

/*------------------------------------------------------------------------------
FUNCTIONS
------------------------------------------------------------------------------*/
void callback_menu(int value);

int create_menu();

void display_cb(void);

void handle_args(int argc, char **argv);

void prompt_for_object();

bool handle_menu_req(int x_delta,int y_delta);

bool handle_object_transform(int x_delta, int y_delta);

bool handle_scene_transform(int x_delta, int y_delta);

bool handle_cel_req(int x_delta, int y_delta);

void init();

void keyboard_cb(unsigned char key, int x, int y);

void mouse_click_cb(int button, int state, int x, int y);

void mouse_drag_cb(int x, int y);

void reshape_cb(int w, int h);

void usage();

int main(int argc, char **argv);

#endif