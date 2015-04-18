/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function show_cart() {
    var products = JSON.parse(sessionStorage.getItem("cart"));
    var list = document.getElementById("product-lists");
    var sum = 0;
    if (products !== null) {
        while (list.hasChildNodes())
        {
            list.removeChild(list.firstChild);
        }
        for (var i = 0; i < products.length; i++) {
            var product = products[i];
            if (product.amount > product.stock)
            {
                list.insertAdjacentHTML("beforeEnd", "<tr id=\"outofstock\">\n" +
                        "                                        <td>" + product.name + "</td>\n" +
                        "                                        <td>" + product.size + "</td>\n" +
                        "                                        <td>$ " + product.price + "</td>\n" +
                        "                                        <td>\n" +
                        "                                            <input type=\"number\" name=\"qty1\" id=\"amount_box_" + product.id + "\" onchange=\"modifyAmount(" + product.id + ")\" value=\"" + product.amount + "\">\n" +
                        "                                        <td>\n" +
                        "                                            <a onclick=\"removeProductFromCart(" + product.id + ")\">Delete this item</a>\n" +
                        "                                        </td>\n" +
                        "                                        <td>$ " + product.price * product + "</td>\n" +
                        "                                    </tr>\n" +
                        "                                    <tr>");
            } else {
                list.insertAdjacentHTML("beforeEnd", "<tr>\n" +
                        "                                        <td>" + product.name + "</td>\n" +
                        "                                        <td>" + product.size + "</td>\n" +
                        "                                        <td>$ " + product.price + "</td>\n" +
                        "                                        <td>\n" +
                        "                                            <input type=\"number\" name=\"qty1\" id=\"amount_box_" + product.id + "\" onchange=\"modifyAmount(" + product.id + ")\" value=\"" + product.amount + "\">\n" +
                        "                                        <td>\n" +
                        "                                            <a onclick=\"removeProductFromCart(" + product.id + ")\">Delete this item</a>\n" +
                        "                                        </td>\n" +
                        "                                        <td>$ " + product.price * product.amount + "</td>\n" +
                        "                                    </tr>\n" +
                        "                                    <tr>");
            }
            sum = sum + product.price * product.amount;
        }
        list.insertAdjacentHTML("beforeEnd", "<tr>\n" +
                "                                        <td colspan='4'></td>\n" +
                "                                        <td class=\"text-right\">Subtotal:</td>\n" +
                "                                        <td> $ " + sum + "</td>\n" +
                "                                    </tr>\n" +
                "                                    <tr>\n" +
                "                                        <td colspan='4'></td>\n" +
                "                                        <td class=\"text-center\"colspan='2'>\n" +
                "                                            <a href=\"index.jsp\"><button type=\"button\" class=\"btn\">Continue Shopping</button></a>\n" +
                "\n" +
                "                                            <a href=\"Checkout.jsp\"><button  class=\"btn btn-primary\">Check out</button></a>\n" +
                "                                        </td>\n" +
                "                                    </tr>");
    }
}

function modifyAmount(id) {
    var box = document.getElementById("amount_box_" + id);
    var current_amount = box.value;
    var products = JSON.parse(sessionStorage.getItem("cart"));
    for (var i = 0; i < products.length; i++) {
        if (products[i].id == id) {
            products[i].amount = current_amount;
        }
    }
    sessionStorage.setItem("cart", JSON.stringify(products));
    show_cart();
}

function removeProductFromCart(id) {
    var products = JSON.parse(sessionStorage.getItem("cart"));
    for (var i = 0; i < products.length; i++) {
        var product = products[i];
        if (product.id == id) {
            products.splice(i, 1);
            var pr = document.getElementById("amount_box_" + id);
            pr.parentNode.removeChild(pr);
        }
    }
    sessionStorage.setItem("cart", JSON.stringify(products));
    show_cart();
}

function checkout() {
    alert("Thank you shopping at wan's website. Your order is submitted.");
}


