/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function addToCart(id) {
    //sessionStorage.removeItem("cart");
    var cart = sessionStorage.getItem("cart");
    var Amount = document.getElementById('Amount').value;
    var Size = document.getElementById('Size').value;
    var xhr = new XMLHttpRequest();
    xhr.open("POST", "GetProductById?id=" + id + "&amount=" + Amount + "&size=" + Size, true);
    xhr.send();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === 4) {
            console.log(xhr.response);
            var product = JSON.parse(xhr.response);
            if (cart === null || cart === "") {
                sessionStorage.setItem("cart", "[" + JSON.stringify(product) + "]");
                sessionStorage.setItem("num", 1);
            } else {
                var products = JSON.parse(cart);
                sessionStorage.setItem("num", products.length);
                for (var i = 0; i < products.length; i++) {
                    if (products[i].id == id) {
                        products[i].amount = parseInt(products[i].amount) + parseInt(Amount);
                        sessionStorage.setItem("cart", JSON.stringify(products));
                        //alert("You already have this product in your bag");
                        return;
                    }
                }
                products.push(product);
                sessionStorage.setItem("cart", JSON.stringify(products));
            }
        }
    };
}

