#version 330 core

layout(location = 0) in vec3 aPos;

uniform mat4 uTransformationMatrix;
uniform mat4 uProjectionMatrix;

out vec3 Position;

void main(void) {
    vec4 worldPosition = vec4(aPos, 1.0) * uTransformationMatrix;

    Position = aPos;

    gl_Position = worldPosition * uProjectionMatrix;
}