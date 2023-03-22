// Class
function Car(brand, name) {
    // 멤버변수
    this.brand = brand;
    this.name = name;
}

// 메소드 추가
Car.prototype.showMyCar = function() {
    console.log("My Car", this.brand);
    console.log("My Car", this.name);
}