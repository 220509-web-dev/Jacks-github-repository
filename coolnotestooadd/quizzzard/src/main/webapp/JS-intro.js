/**
 * this is a documentation comment that goes on top of functions to describe behavior
 */
function exampleFunction() {
}
var variable1 = '5';
console.log(variable1);

class Cat {

    constructor(name, furColor, breed = 'Domestic Shorthair') {
        this.name = name;
        this.furColor = furColor;
        this.breed = breed;

    }

    makeSound() {
        console.log('Meow!');
    }
}

let someCat = new Cat('Paul', 'black');
console.log(someCat);
console.log(someCat.makeSound());