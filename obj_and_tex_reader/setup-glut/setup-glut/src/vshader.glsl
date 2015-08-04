#version 420

in  vec4 vPosition;
in  vec4 vNormal;
in  vec2 vTexture;

// model view, lighting
uniform mat4 Model;
uniform mat4 View;
uniform mat4 Projection;
uniform vec4 LightPosition;
uniform float Shininess;

// selection settings
uniform bool sel_flag;
uniform int sel_color;

// custom color setting
uniform bool cc_flag;
uniform vec4 cc;

// output
smooth out vec3 vNorm;
smooth out vec3 vEye;
smooth out vec3 vLightDir;

// note that color isn't always used!
out vec4 color;

out vec2 vFragText;

void main()
{
	// Transform vertex position into eye coordinates
	vec4 posw = (View * Model * vPosition);
	vec3 pos = posw.xyz / posw.w;

	// Transform vertex normal into eye coordinates
	//vNorm = normalize( View * Model * vNormal ).xyz;
	// note: the correct matrix to transform the normal is the transpose
	//       of the inverse of the M matrix
	vNorm = (transpose(inverse(View * Model)) * vNormal).xyz;

	// compute the eye vector (vertex point to the eye)
	vEye = normalize( -pos );

	// set light direction
	vLightDir = normalize((View * LightPosition).xyz - pos);

	// set position
	gl_Position = Projection * View * Model * vPosition;

	// uv of the vertex, no special spacing
	vFragText = vTexture;

	// color enabled shader types
	if (sel_flag == true){
		color.r = float(sel_color)/float(256);
		color.g = 0.0;
		color.b = 0.0;
		color.a = 1.0;

	} else if (cc_flag == true) {
		color = cc;
	}
}
