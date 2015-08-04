// A simple 2D OpenGL program using GLUT

// Include the vector and matrix utilities from the textbook, as well as some
// macro definitions.
#include "Angel.h"

#ifdef __APPLE__
#define GL3_PROTOTYPES
#include <OpenGL/gl3.h>
#endif

const int NumVertices = 3;

void init()
{
    // Specifiy the vertices for a triangle.
    vec2 vertices[] = {
        vec2(-0.5, 0.5),
        vec2(-0.5, -0.5),
        vec2(0.5, -0.5),
    };

    // Create a vertex array object---OpenGL needs this to manage the Vertex
    // Buffer Object
    GLuint vao;

    // Generate the vertex array and then bind it to make make it active.
    glGenVertexArrays(1, &vao);
    glBindVertexArray(vao);

    // Create and initialize a buffer object---that's the memory buffer that
    // will be on the card!
    GLuint vbo;

    // We only need one for this example.
    glGenBuffers(1, &vbo);

    // Bind makes it the active VBO
    glBindBuffer(GL_ARRAY_BUFFER, vbo);

    // Here we copy the vertex data into our buffer on the card.  The parameters
    // tell it the type of buffer object, the size of the data in bytes, the
    // pointer for the data itself, and a hint for how we intend to use it.
    glBufferData(GL_ARRAY_BUFFER, sizeof(vertices), vertices, GL_STATIC_DRAW);

    // Load the shaders.  Note that this function is not offered by OpenGL
    // directly, but provided as a convenience.
    GLuint program = InitShader("src/vertshader.glsl", "src/fragshader.glsl");

    // Make that shader program active.
    glUseProgram(program);

    // Initialize the vertex position attribute from the vertex shader.  When
    // the shader and the program are linked, a table is created for the shader
    // variables.  Here, we get the index of the vPosition variable.
    GLuint vPostionLoc = glGetAttribLocation(program, "position");

    // We want to set this with an array!
    glEnableVertexAttribArray(vPostionLoc);

    // We map it to this offset in our current buffer (VBO) So, our position
    // data is going into loc and contains 2 floats.  The parameters to this
    // function are the index for the shader variable, the number of components,
    // the type of the data, a boolean for whether or not this data is
    // normalized (0--1), stride (or byte offset between consective attributes),
    // and a pointer to the first component.  Note that BUFFER_OFFSET is a macro
    // defined in the Angel.h file.
    glVertexAttribPointer(vPostionLoc, 2, GL_FLOAT, GL_FALSE, 0, (GLvoid*)0);

    // Make the background white
    glClearColor(0.2, 0.2, 0.2, 1.0);
}

void keyboard(unsigned char key, int x, int y)
{
    switch (key)
    {
    case 27:
        // Quit when ESC is pressed
        exit(EXIT_SUCCESS);
        break;
    }
}

void display()
{
    // Clear the window
    glClear(GL_COLOR_BUFFER_BIT);
    // Draw the points. The parameters to the function are:
    // the mode, the first index, and the count.
    glDrawArrays(GL_TRIANGLES, 0, NumVertices);
    glFlush();
    glutSwapBuffers();
}

int main(int argc, char** argv)
{
    glutInit(&argc, argv);
#ifdef __APPLE__
    glutInitDisplayMode(GLUT_3_3_CORE_PROFILE | GLUT_RGBA | GLUT_DOUBLE);
#else
    glutInitDisplayMode(GLUT_RGBA | GLUT_DOUBLE);
    glutInitContextVersion(3, 3);
    glutInitContextFlags(GLUT_FORWARD_COMPATIBLE);
#endif
    glutInitWindowSize(512, 512);
    glutInitWindowPosition(500, 300);
    glutCreateWindow("Simple Open GL Program");
    printf("%s\n%s\n", glGetString(GL_RENDERER), glGetString(GL_VERSION));

    // GLEW must be initialized AFTER a context is created
    glewExperimental = GL_TRUE;
    glewInit();

    glutKeyboardFunc(keyboard);
    glutDisplayFunc(display);

    init();
    glutMainLoop();
    return 0;
}
