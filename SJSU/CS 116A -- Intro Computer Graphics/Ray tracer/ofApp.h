// ofApp.h
// Created by:
// Catalina Lamboglia
// Last edit: 10/26/2020


//
//  RayCaster - Set of simple classes to create a camera/view setup for our Ray Tracer HW Project
//
//  I've included these classes as a mini-framework for our introductory ray tracer.
//  You are free to modify/change.   
//
//  These classes provide a simple render camera which can can return a ray starting from
//  it's position to a (u, v) coordinate on the view plane.
//
//  The view plane is where we can locate our photorealistic image we are rendering.
//  The field-of-view of the camera by moving it closer/further 
//  from the view plane.  The viewplane can be also resized.  When ray tracing an image, the aspect
//  ratio of the view plane should the be same as your image. So for example, the current view plane
//  default size is ( 6.0 width by 4.0 height ).   A 1200x800 pixel image would have the same
//  aspect ratio.
//
//  This is not a complete ray tracer - just a set of skelton classes to start.  The current
//  base scene object only stores a value for the diffuse/specular color of the object (defaut is gray).
//  at some point, we will want to replace this with a Material class that contains these (and other 
//  parameters)
//  
//  (c) Kevin M. Smith  - 24 September 2018
//
#pragma once


#include "ofMain.h"
#include "glm/gtx/intersect.hpp"


//  General Purpose Ray class 
//
class Ray {
public:
	Ray(glm::vec3 p, glm::vec3 d) { this->p = p; this->d = d; }
	void draw(float t) { ofDrawLine(p, p + t * d); }

	glm::vec3 evalPoint(float t) {
		return (p + t * d);
	}

	glm::vec3 p, d;
};

//  Base class for any renderable object in the scene
//
class SceneObject {
public: 
	virtual void draw() = 0;    // pure virtual funcs - must be overloaded
	virtual bool intersect(const Ray &ray, glm::vec3 &point, glm::vec3 &normal) { cout << "SceneObject::intersect" << endl; return false; }
	// added for mesh compatibility
	virtual ofColor getDiffuse(glm::vec3 point) = 0;
	virtual ofColor getSpecular(glm::vec3 point) = 0;
	// any data common to all scene objects goes here
	glm::vec3 position = glm::vec3(0, 0, 0);

	// material properties (we will ultimately replace this with a Material class - TBD)
	//
	ofColor diffuseColor = ofColor::grey;    // default colors - can be changed.
	ofColor specularColor = ofColor::lightGray;
};

//  General purpose sphere  (assume parametric)
//
class Sphere: public SceneObject {
public:
	Sphere(glm::vec3 p, float r, ofColor diffuse = ofColor::lightGray) { position = p; radius = r; diffuseColor = diffuse; specularColor = ofColor::white; }
	Sphere() {}
	bool intersect(const Ray &ray, glm::vec3 &point, glm::vec3 &normal) {
		return (glm::intersectRaySphere(ray.p, ray.d, position, radius, point, normal));
	}
	void draw()  { 
		ofDrawSphere(position, radius); 
	}
	// dummy methods, just to allow all scene objects to be drawn like a floor (with a mesh)
	ofColor getDiffuse(glm::vec3 point) {
		return diffuseColor;
	}
	ofColor getSpecular(glm::vec3 point) {
		return specularColor;
	}



	float radius = 1.0;
};

//  Mesh class (will complete later- this will be a refinement of Mesh from Project 1)
//
class Mesh : public SceneObject {
	bool intersect(const Ray &ray, glm::vec3 &point, glm::vec3 &normal) { return false;  }
	void draw() { }
	ofColor getDiffuse(glm::vec3 point) {
		return diffuseColor;
	}
	ofColor getSpecular(glm::vec3 point) {
		return specularColor;
	}
};


//  General purpose plane 
//
class Plane: public SceneObject {
public:
	Plane(glm::vec3 p, glm::vec3 n, ofColor diffuse = ofColor::darkOliveGreen, float w = 20, float h = 20) {
		position = p; normal = n;
		width = w;
		height = h;
		diffuseColor = diffuse;
		plane.rotateDeg(90, 1, 0, 0);

		if (texture.load("images/woodSpecular.jpg"))
			hasTexture = true;
		else
			hasTexture = false;

		// debugging texture
		//texture2.load("images/testTexture2.jpg");
	}
	Plane() {
		normal = glm::vec3(0, 1, 0); 
	plane.rotateDeg(90, 1, 0, 0); }

	glm::vec3 normal = glm::vec3(0, 1, 0);
	bool intersect(const Ray &ray, glm::vec3 & point, glm::vec3 & normal);
	void draw() {
		plane.setPosition(position);
		plane.setWidth(width);
		plane.setHeight(height);
		plane.setResolution(4, 4);
		plane.drawWireframe();
	}

	// get color from mesh if loaded, else return default
	ofColor getDiffuse(glm::vec3 point) {
		if (hasTexture)
		{
			// tried just using the dimensions of the plane like an image
			// causes distortions in texture and portions not loading
			//float u = (float(point.x) + .5) / float(width);
			//float v = (float(point.y) + .5) / float(height);
			//
			// instead representing by using normal and orthagonals
			//float u = glm::dot(uVec, point);
			//float v = glm::dot(vVec, point);

			// direct mapping a range of values
			//		int imageWidth = 1600;
			//		int imageHeight = 1200;
			// shouldnt hard code later, need to save the screen dimensions in scope
			//glm::vec3 p = glm::normalize(point);

			// translate from screen to plane, then plane to uv
			//float u = ofMap(p.x, 0, 1600, 0, 20);
			//float v = ofMap(p.y, 0, 1200, 0, 20);
			//u = ofMap(u, 0, width, 0, 1);
			//v = ofMap(v, 0, height, 0, 1);

			//float x = point.x + (width / 2);
			//float z = point.z + (height / 2);

			//u = (x + .5) / width;
			//v = (z + .5) / height;
			float x = point.x + (texture.getWidth() / 2);
			float z = point.z + (texture.getWidth() / 2);

			float u = (x + .5) / texture.getWidth();
			float v = (z + .5) / texture.getWidth();

			u = u * numSquares;
			v = v * numSquares;
			//float u = ofMap(point.x, 0, texture.getWidth(), 0, 1);
			//float v = ofMap(point.y, 0, texture.getHeight(), 0, 1);

			float i = round(u * texture.getWidth() - .5);
			float j = round(v * texture.getHeight() - .5);

			// bounds checking, wrap
			//if (i > texture.getWidth())
			//	i = remainder(i, texture.getWidth());

			//if (j > texture.getHeight())
			//	j = remainder(j, texture.getHeight());

			//if (i < 0)
			//	i = 0.0f;

			//if (j < 0)
			//	i = 0.0f;

			//cout << "Diffuse: " << endl;
			//cout << "[ " + to_string(i) + ", " + to_string(j) + ", " + to_string(u) + ", " + to_string(v) + "]" << endl;
			//i = remainder(i, texture.getWidth());
			//j = remainder(j, texture.getHeight());

			// intended to color the read pixels black to ensure it was reading the entire texture file
			// but this style implementation requires a save every time you make a change which is extremely slow
			// so not doing this debug method, at least in this exact method

			//texture2.setColor((int)i, (int)j, ofColor::black);
			//ofPixels pix = texture.getPixels();

			 return texture.getColor((int)fmod(i, texture.getWidth()), (int)fmod(j, texture.getHeight()));
			//return pix.getColor((int)i, (int)j);
		}
		else
			return diffuseColor;
	}
	// get color from mesh if loaded, else return default
	ofColor getSpecular(glm::vec3 point) {
		if (hasTexture)
		{
			//float u = (float(point.x) + .5) / float(width);
			//float v = (float(point.y) + .5) / float(height);
			
			//float u = glm::dot(uVec, point);
			//float v = glm::dot(vVec, point);

			//float u = (float(point.x)) / float(width);
			//float v = (float(point.y)) / float(height);

			// direct mapping a range of values
			//float u = ofMap(point.x, 0, width, 0, 1);
			//float v = ofMap(point.y, 0, height, 0, 1);
			//glm::vec3 p = glm::normalize(point);

			// translate from screen to plane, then plane to uv
			//float u = ofMap(p.x, 0, 1600, 0, 20);
			//float v = ofMap(p.y, 0, 1200, 0, 20);
			//u = ofMap(u, 0, width, 0, 1);
			//v = ofMap(v, 0, height, 0, 1);

			float x = point.x + (texture.getWidth() / 2);
			float z = point.z + (texture.getHeight() / 2);

			float u = (x + .5) / texture.getWidth();
			float v = (z + .5) / texture.getHeight();

			u = u * numSquares;
			v = v * numSquares;
			//float i = u * texture.getWidth() - .5;
			//float j = v * texture.getHeight() - .5;
			float i = round(u * texture.getWidth() - .5);
			float j = round(v * texture.getHeight() - .5);

			// bounds checking, wrap
			//if (i > texture.getWidth())
			//	i = remainder(i, texture.getWidth());

			//if (j > texture.getHeight())
			//	j = remainder(j, texture.getHeight());

			//if (i < 0)
			//	i = 0.0f;

			//if (j < 0)
			//	i = 0.0f;
			//i = remainder(i, texture.getWidth());
			//j = remainder(j, texture.getHeight());

			//cout << "Specular: " << endl;
			//cout << "[ " + to_string(i) + ", " + to_string(j) + ", " + to_string(u) + ", " + to_string(v) + "]" << endl;
			//texture2.setColor((int)i, (int)j, ofColor::black);
			//texture2.save("images/testTexture2.jpg");

			//ofPixels pix = texture.getPixels();

			// return texture.getColor((int)i, (int)j);
			return texture.getColor((int)fmod(i, texture.getWidth()), (int)fmod(j, texture.getHeight()));
			//return pix.getColor((int)i, (int)j);
		}
		else
			return specularColor;
	}
	ofPlanePrimitive plane;
	/*glm::vec3 normal;*/

	// for u,v coordinates for use in mesh
	//	glm::vec3 uVec = normalize(glm::vec3(1, 1, 0)); // orth to normal
	//glm::vec3 uVec = normalize(glm::vec3(normal.y, -normal.x, 0));
	//glm::vec3 vVec = normalize(glm::cross(normal, uVec));

	//glm::vec3 orthU = glm::cross(normal, uVec) / vVec;
	//glm::vec3 orthV = glm::cross(normal, orthU);
	//glm::vec3 orthV = orthV / normalize(orthV);

	ofImage texture;

	// visual debugging texture
	ofImage texture2;

	// "10x10 squares" (set higher for looks)
	int numSquares = 1000;

	bool hasTexture;
	float width = 20;
	float height = 20;
};

class Light : public SceneObject {
public:
	Light()
	{
		radius = .1;
		intensity = .1;
		ambientIntensity = .01;
		position = glm::vec3(0, 1, 0);
	}
	void draw()
	{
		ofDrawSphere(position, radius);
	}
	ofColor getDiffuse(glm::vec3 point) {
		return diffuseColor;
	}
	ofColor getSpecular(glm::vec3 point) {
		return specularColor;
	}

	glm::vec3 position;
	float intensity, radius, ambientIntensity;
};





// view plane for render camera
// 
class  ViewPlane: public Plane {
public:
	ViewPlane(glm::vec2 p0, glm::vec2 p1) { min = p0; max = p1; }

	ViewPlane() {                         // create reasonable defaults (6x4 aspect)
		min = glm::vec2(-3, -2);
		max = glm::vec2(3, 2);
		position = glm::vec3(0, 0, 5);
		normal = glm::vec3(0, 0, 1);      // viewplane currently limited to Z axis orientation
	}

	void setSize(glm::vec2 min, glm::vec2 max) { this->min = min; this->max = max; }
	float getAspect() { return width() / height(); }

	glm::vec3 toWorld(float u, float v);   //   (u, v) --> (x, y, z) [ world space ]

	void draw() {
		ofDrawRectangle(glm::vec3(min.x, min.y, position.z), width(), height());
	}

	ofColor getDiffuse(glm::vec3 point) {
		return diffuseColor;
	}
	ofColor getSpecular(glm::vec3 point) {
		return specularColor;
	}
	
	float width() {
		return (max.x - min.x);
	}
	float height() {
		return (max.y - min.y); 
	}

	// some convenience methods for returning the corners
	//
	glm::vec2 topLeft() { return glm::vec2(min.x, max.y); }
	glm::vec2 topRight() { return max; }
	glm::vec2 bottomLeft() { return min;  }
	glm::vec2 bottomRight() { return glm::vec2(max.x, min.y); }

	//  To define an infinite plane, we just need a point and normal.
	//  The ViewPlane is a finite plane so we need to define the boundaries.
	//  We will define this in terms of min, max  in 2D.  
	//  (in local 2D space of the plane)
	//  ultimately, will want to locate the ViewPlane with RenderCam anywhere
	//  in the scene, so it is easier to define the View rectangle in a local'
	//  coordinate system.
	//
	glm::vec2 min, max;
};


//  render camera  - currently must be z axis aligned (we will improve this in project 4)
//
class RenderCam: public SceneObject {
public:
	RenderCam() {
		position = glm::vec3(0, 0, 10);
		aim = glm::vec3(0, 0, -1);
	}
	Ray getRay(float u, float v);
	void draw() { ofDrawBox(position, 1.0); };
	void RenderCam::drawFrustum();
	ofColor getDiffuse(glm::vec3 point) {
		return diffuseColor;
	}
	ofColor getSpecular(glm::vec3 point) {
		return specularColor;
	}

	glm::vec3 aim;
	ViewPlane view;          // The camera viewplane, this is the view that we will render 
};

  

class ofApp : public ofBaseApp{

	public:
		void setup();
		void update();
		void draw();

		void keyPressed(int key);
		void keyReleased(int key);
		void mouseMoved(int x, int y );
		void mouseDragged(int x, int y, int button);
		void mousePressed(int x, int y, int button);
		void mouseReleased(int x, int y, int button);
		void mouseEntered(int x, int y);
		void mouseExited(int x, int y);
		void windowResized(int w, int h);
		void dragEvent(ofDragInfo dragInfo);
		void gotMessage(ofMessage msg);
		void rayTrace();
		void drawGrid();
		void drawAxis(glm::vec3 position);

		ofColor lambert(const glm::vec3 &p, const glm::vec3 &norm, const ofColor diffuse);
		ofColor phong(const glm::vec3 &p, const glm::vec3 &norm,
			 const ofColor specular, float power);
		ofColor phongBlinn(const glm::vec3 &p, const glm::vec3 &norm,
			const ofColor diffuse, const ofColor specular, float power);
	
		float distanceBetween(glm::vec3 p1, glm::vec3 p2);
		float dotProduct(glm::vec3 a, glm::vec3 b);

		bool bHide = true;
		bool bShowImage = false;

		ofEasyCam  mainCam;
		ofCamera sideCam;
		ofCamera previewCam;
		ofCamera  *theCam;    // set to current camera either mainCam or sideCam

		// set up one render camera to render image throughn
		//
		RenderCam renderCam;
		ofImage image;

		vector<SceneObject *> scene;
		vector<Sphere> spheres;
		vector<Light> lights;

		ViewPlane *myPlane;
		Plane *plane;
		bool blocked = false;
		int blockedCount = 0;
		
		ofColor color;

		int imageWidth = 1600;
		int imageHeight = 1200;
};
 