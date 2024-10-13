#version 330 core

in vec3 Position;

out vec4 FragColor;

void main(void) {
    vec3 firstColor = vec3(0.0, 1.0, 1.0);
    vec3 secondColor = vec3(1.0, 0.0, 0.0);

    float dist = dot(Position, Position) / 8000;

    FragColor = vec4((1 - vec3(abs(sin(dist))))
    * mix(firstColor, secondColor, dist / 8), 1.0);
}
