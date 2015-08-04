#version 420

in      vec4 color;
in      vec3 vEye;
in      vec3 vLightDir;
in      vec3 vNorm;
in      vec2 vFragText;

// lighting properties
uniform vec4 AmbientProduct, DiffuseProduct, SpecularProduct;
uniform float Shininess;

// cel shader settigns
uniform bool cel_flag;
uniform int  cel_shades;

// selection color settings
uniform bool sel_flag;
uniform int  sel_color;

// custom color setting
uniform bool cc_flag;
uniform vec4 cc;

// texture uniforms
uniform sampler2D tex;
//
uniform bool test_flag;


// output
out     vec4 fColor;

void main()
{
	// simple passthrough for manually set color types
	if (sel_flag == true) {
		fColor = color;
		return;
	} else if (cc_flag == true) {
		fColor = color;
		return;
	}

	// load the texture
	vec4 map_color =texture(tex, vFragText);
	if(test_flag==true){
	 map_color = color*map_color;
					}
						
	// use the phong shader
	float delta = max(0.0, dot(normalize(vNorm), normalize(vLightDir)));
	fColor = map_color * delta * DiffuseProduct;

	// hack: assume map_Kd = map_Ka
	// TODO load multiple textures
	fColor += map_color * AmbientProduct;

	vec3 vReflection = normalize(reflect(-normalize(vLightDir), normalize(vNorm)));

	float spec = max(0.0, dot(vEye, vReflection));
	if (delta != 0) {
		float fSpec = pow(spec, Shininess);
		fColor.rgb += vec3(fSpec, fSpec, fSpec);
	}

	// additional processing for cel shading
	if (cel_flag == true) {
		float step = 1.0 / cel_shades;

		// round color to be an even multiple
		fColor.r = floor(fColor.r / step) * step;
		fColor.g = floor(fColor.g / step) * step;
		fColor.b = floor(fColor.b / step) * step;

		// fragment is on a silhouette if the eye vector and normal
		// vector are near perpendicular (dot product near zero)
		float dp = dot(vEye, vNorm);
		if ((-0.25 < dp) && (dp < 0.25)) {
			fColor = vec4(0.0, 0.0, 0.0, 0.0);
		}
	}
}