# Project 1: Java Ray Tracer

## Description  
A from-scratch ray-tracing engine written in pure Java. This program reads a simple scene description (spheres, planes and an optional OBJ mesh), lights it with ambient, point, and directional sources, and outputs a photorealistic PNG image by simulating light paths.

## Features  
- **Geometry**:  
  - **Spheres** (class `Surface.Sphere`)  
  - **Implicit ground plane** (large sphere trick)  
  - **Triangle meshes** via `OBJReader` (e.g. `bunny.obj`)  
- **Shading**: Phong illumination with ambient, diffuse & specular terms  
- **Shadows**: shadow-ray testing for hard shadows  
- **Reflection**: recursive mirror rays  
- **Refraction**: transparent materials with configurable index of refraction  
- **Anti-Aliasing**: supersampling (configurable “SuperSamplingLevel”) using Java parallel streams  
- **Configurable camera** (`Camera` class) with position & orientation  
- **Output**: writes `output2.png` via Java Image I/O

## Prerequisites  
- **Java 11+** JDK (or newer)  
- **JOML** (Java OpenGL Math Library) on your classpath  
- (Optional) **IDE config**: IntelliJ/MS VS Code project file is included (`javaraytracer.iml`).

## Build & Run (CLI)  
1. **Clone** or copy this folder so you’re in `Project 1/`.  
2. Place `bunny.obj` in the same directory (if you want mesh rendering).  
3. **Compile** all `.java` files, pointing to the JOML jar:

   ```bash
   # adjust path/to/joml.jar as needed
   javac -cp .:path/to/joml.jar *.java
