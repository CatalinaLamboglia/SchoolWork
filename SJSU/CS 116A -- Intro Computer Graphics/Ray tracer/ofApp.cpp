// ofApp.cpp
// Created by:
// Catalina Lamboglia
// Last edit: 10/13/2020

#include "ofApp.h"
#include "glm/gtx/intersect.hpp"
#include <algorithm>
#include <math.h>
#include <cmath> 

// Intersect Ray with Plane  (wrapper on glm::intersect*
//
bool Plane::intersect(const Ray &ray, glm::vec3 & point, glm::vec3 & normalAtIntersect) {
	float dist;
	bool insidePlane = false;
	bool hit = glm::intersectRayPlane(ray.p, ray.d, position, this->normal, dist);
	if (hit) {
		Ray r = ray;
		point = r.evalPoint(dist);
		normalAtIntersect = this->normal;
		glm::vec2 xrange = glm::vec2(position.x - width / 2, position.x + width / 2);
		glm::vec2 zrange = glm::vec2(position.z - height / 2, position.z + height / 2);
		if (point.x < xrange[1] && point.x > xrange[0] && point.z < zrange[1] && point.z > zrange[0]) {
			insidePlane = true;
		}
	}
	return insidePlane;
}



// Convert (u, v) to (x, y, z) 
// We assume u,v is in [0, 1]
//
glm::vec3 ViewPlane::toWorld(float u, float v) {
	float w = width();
	float h = height();
	return (glm::vec3((u * w) + min.x, (v * h) + min.y, position.z));
}

// Get a ray from the current camera position to the (u, v) position on
// the ViewPlane
//
Ray RenderCam::getRay(float u, float v) {
	glm::vec3 pointOnPlane = view.toWorld(u, v);
	return(Ray(position, glm::normalize(pointOnPlane - position)));
}

void RenderCam::drawFrustum()
{
	view.draw();
	Ray r1 = getRay(0, 0);
	Ray r2 = getRay(0, 1);
	Ray r3 = getRay(1, 1);
	Ray r4 = getRay(1, 0);
	float dist = glm::length((view.toWorld(0, 0) - position));
	r1.draw(dist);
	r2.draw(dist);
	r3.draw(dist);
	r4.draw(dist);
}

void ofApp::setup()
{
	//theCam = &easyCam;
	//easyCam.setDistance(2);
	//easyCam.setNearClip(.1);
	//sideCam.setPosition(glm::vec3(5, 0, 0));
	//sideCam.lookAt(glm::vec3(0, 0, 0));
	//sideCam.setNearClip(.1);
	Sphere *sphere1 = new Sphere(glm::vec3(-.5, -.25, 7), 0.4, ofColor::lime);
	Sphere *sphere2 = new Sphere(glm::vec3(-.2, .2, 6), 0.6, ofColor::fuchsia);
	Sphere *sphere3 = new Sphere(glm::vec3(.2, 0, 6.5), 0.5, ofColor::blueSteel);


	//shifting for looks
	sphere1->position.x += .2;
	sphere1->position.y += .3;
	sphere2->position.x += .2;
	sphere2->position.y += .1;
	sphere3->position.x += .2;
	sphere3->position.y += .1;

	// plane not being drawn, fix later
	plane = new Plane(glm::vec3(0, 0, 0), glm::vec3(0, 1, 0), ofColor::pink, 20.0, 20.0);
	//plane.diffuseColor = ofColor::brown;
	myPlane = new ViewPlane();

	scene.push_back(sphere1);
	scene.push_back(sphere2);
	scene.push_back(sphere3);

	plane->position.y += -.5;

	scene.push_back(plane);
	//scene.push_back(myPlane);


	// unsure if this is still being used:
	// will leave it in
	// pointers and polymorphism are being wonky, just make a new vector
	// where they can just be drawn from
	spheres.push_back(*sphere1);
	spheres.push_back(*sphere2);
	spheres.push_back(*sphere3);

	// default position (0, 1, 0);
	Light light = Light();
	light.position = glm::vec3(0, 1, 8);

	Light light2 = Light();
	light2.position = glm::vec3(-3, 0, 6);
	//light2.intensity = .2;

	Light light3 = Light();
	light3.position = glm::vec3(1, 2, 7);


	lights.push_back(light);
	lights.push_back(light2);
	lights.push_back(light3);

	mainCam.setDistance(30);
	theCam = &mainCam;

	renderCam = RenderCam();

	image = ofImage();
	image.allocate(imageWidth, imageHeight, OF_IMAGE_COLOR);
	



	//image.setColor(ofColor::red);
	//image.update();
	////image.save("F:\Program Files\of_v0.11.0_vs2017_release\apps\myApps\testImg.png", OF_IMAGE_QUALITY_BEST);
	//image.save("testImg.png", OF_IMAGE_QUALITY_BEST);


}

void ofApp::update()
{
}

void ofApp::draw()
{
	theCam->begin();
	//myPlane.draw();

	// basically checking if objects can be drawn
	// emulating java's "instanceOf" method
	//for (int n = 0; n < scene.size(); n++)
	//{
	//	if (Sphere* v = dynamic_cast<Sphere*>(scene[n]))
	//	{
	//		scene.at(n)->draw();
	//	}
	//	else if (Plane* v = dynamic_cast<Plane*>(scene[n]))
	//	{
	//		scene.at(n)->draw();
	//	}
	//	else if (ViewPlane* v = dynamic_cast<ViewPlane*>(scene[n]))
	//	{
	//		scene.at(n)->draw();
	//	}
	//}
	renderCam.drawFrustum();

	for (Sphere sp : spheres)
	{
		sp.draw();
	}
	plane->draw();
	for (Light light : lights)
	{
		light.draw();
	}


	
	theCam->end();
}

void ofApp::keyPressed(int key)
{
	switch (key) {
	case 'r':
		rayTrace();
		break;
	default:
		break;
	}

	
}

void ofApp::keyReleased(int key)
{
}

void ofApp::mouseMoved(int x, int y)
{
}

void ofApp::mouseDragged(int x, int y, int button)
{
}

void ofApp::mousePressed(int x, int y, int button)
{
}

void ofApp::mouseReleased(int x, int y, int button)
{
}

void ofApp::mouseEntered(int x, int y)
{
}

void ofApp::mouseExited(int x, int y)
{
}

void ofApp::windowResized(int w, int h)
{
}

void ofApp::dragEvent(ofDragInfo dragInfo)
{
}

void ofApp::gotMessage(ofMessage msg)
{
}

void ofApp::rayTrace()
{

	// iterate in "pixel" space starting from lower-left corner
	//
	for (int j = 0; j < imageHeight; j++) {
		for (int i = 0; i < imageWidth; i++) {

			// from slides from lecture; compute a normalized (u, v) in [0  1.0]
			// from the pixel coordinates. we get back a (u, v) that is centered
			//  in pixel(i, j). "v" is up.  The "float" casting shoud not be 
			// necessary for newer C++ compilers, but I'm just being explicit here.
			//
			float u = (float(i) + .5) / float(imageWidth);
			float v = (float(j) + .5) / float(imageHeight);

			// we have a helper function that gives world space coordinates (x, y, z)
			// from (u, v)
			//
			Ray ray = renderCam.getRay(u, v);

			glm::vec3 point, normal;
			bool hit = false;
			int nearestObj = -1;
			glm::vec3 nearestPoint, nearestNorm;

			// initialize to a very big number ()
			//
			float nearestDist = std::numeric_limits<float>::infinity();

			// we loop through all our objects in the scene and call the intersect() method
			// on the SceneObject. All primitives (sphere, plane, mesh) inherit from SceneObject
			// so their specialized intersect function will be automatically called. (polymorphism)
			// we keep track of the distance of objects that are intersected; we want
			// the closest object (to the camera )
			//

			// checking if should darken
			blocked = false;
			blockedCount = 0;

			for (int n = 0; n < scene.size(); n++) {
				
				if (scene.at(n)->intersect(ray, point, normal)) {

					float dist = glm::length(point - renderCam.position);
					//blockedCount++;
					if (dist < nearestDist) {
						nearestDist = dist;
						nearestObj = n;
						nearestPoint = point;
						nearestNorm = normal;
					}
					hit = true;

				}
			}

			// determine shadows here 

			// need to go through rays from lights to scene objects
			//for (int n = 0; n < scene.size(); n++) 
			//{
			//  for (lights in lights)
			//      make ray here
			//	if (scene.at(n)->intersect(ray, point, normal)) 
			//	{

			//	}
			//}

			// if intersected more than twice then it's blocked
			if (blockedCount >= 2)
				blocked = true;


			// Set the color of the pixel to the nearest object's pixel
			// if we didn't hit anything, set it the bg color (Black for now).
			//
			// This is a little tricky. Some image file formats and API's
			// assume that the pixel (0, 0) is in the upper left and this is the 
			// case with OpenFrameworks jpeg images.  So we need to make sure
			// we adjust for that in the "j" direction, otherwise our image
			// will come out "flipped".
			//
			if (!hit) {

				// set color to black if we don't hit anything
				//
				image.setColor(i, imageHeight - j - 1, ofColor::skyBlue);
			}
			else {
				// For Part 1 of the project, all we need to do is just set the color
				// in the image with the diffuseColor of the nearest object we hit
				//
				//color = scene[nearestObj]->diffuseColor;

				//  For Part 2 we implement this a little differently, instead of just
				//  using the diffuse color of the object, we compute the color
				// from a shader  (lambert, blinn-phong)
				//  Ex:




				//		ofColor color = shader(....);
				// add lambert
				color = lambert(nearestPoint, nearestNorm, scene.at(nearestObj)->getDiffuse(point));

				// add phong // the .1 is not an acceptable number but for the sake of a nice image that's what will be used
				color += phong(nearestPoint, nearestNorm, scene.at(nearestObj)->getSpecular(point), .01);

				// add ambient
				for (Light light : lights)
				{
					color += scene.at(nearestObj)->getDiffuse(point) * light.intensity;
				}


				//color = phongBlinn(nearestPoint, nearestNorm, scene.at(nearestObj)->diffuseColor, scene.at(nearestObj)->specularColor, 10.0);


				image.setColor(i, imageHeight - j - 1, color);
			}
		}
	}
	image.save("out.jpg");
}

void ofApp::drawGrid()
{
}

void ofApp::drawAxis(glm::vec3 position)
{
}

ofColor ofApp::lambert(const glm::vec3 & p, const glm::vec3 & norm, const ofColor diffuse)
{
	// Ld = kd(I/r^2)max(0, n*l) where n*l is a dot product
	// write a loop later for all lights
	ofColor res = ofColor(0, 0, 0);
	float r;
	for (Light light : lights)
	{
		glm::vec3 n = glm::normalize(norm);
		r = glm::distance(p, light.position);
		glm::vec3 l = glm::normalize(light.position - p);
		//		r = glm::distance(norm, light.position);
		/*res += diffuse * (light.intensity / pow(r, 2)) * max(0.0f, glm::dot(light.position, n));*/
		res += diffuse * light.intensity * max(0.0f, glm::dot(n, l));
	}

	//float r = distanceBetween(p, lights.at(0).position);
	//ofColor res = diffuse * (lights.at(0).intensity / pow(r, 2)) * max(0.0f, dotProduct(p, norm));

	return res;
}

ofColor ofApp::phong(const glm::vec3 & p, const glm::vec3 & norm, const ofColor specular, float power)
{
	ofColor res = ofColor(0, 0, 0);
	glm::vec3 v = glm::normalize(renderCam.position - p);
	glm::vec3 h, l;

	for (Light light : lights)
	{
		glm::vec3 n = glm::normalize(norm);
		l = glm::normalize(light.position - p);
		h = glm::normalize(v + l);
		float r = glm::distance(p, light.position);
		r = r * r;
		res += specular * (light.intensity / r) * glm::pow(max(0.0f, glm::dot(h, n)), power);
		//res += specular * (light.intensity / pow(r, 2)) * pow(max(0.0f, glm::dot(h, norm)), power);
	}
	return res;
}




// just a test method
// theyre all added in the ray trace body
// has the incorrect phong shader in the calculation
ofColor ofApp::phongBlinn(const glm::vec3 & p, const glm::vec3 & norm, const ofColor diffuse, const ofColor specular, float power)
{
	// write a loop later for all lights
	ofColor res;
	float r = glm::distance(p, lights.at(0).position);
	res += specular * (lights.at(0).intensity / pow(r, 2)) * pow(max(0.0f, glm::dot(p, norm)), power) +
	//	diffuse * (lights.at(0).intensity / pow(r, 2)) * max(0.0f, dotProduct(p, norm)) +
		diffuse * lights.at(0).intensity;

	return res;
}




float ofApp::distanceBetween(glm::vec3 p1, glm::vec3 p2)
{
	return sqrt(pow((p2.x - p1.x), 2) + pow((p2.y - p1.y), 2));
}

float ofApp::dotProduct(glm::vec3 a, glm::vec3 b)
{
	return (a.x * b.x + a.y * b.y + a.z * b.z);
}
