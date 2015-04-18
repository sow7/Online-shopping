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
            list.insertAdjacentHTML("beforeEnd", "<tr>\n" +
                    "                                        <td>" + product.name + "<input type=\"hidden\" name=\"productid\" value=\"" + product.id + "\"/></td>\n" +
                    "                                        <td>" + product.size + "<input type=\"hidden\" name=\"productid\" value=\"" + product.size + "\"/></td>\n" +
                    "                                        <td>$ " + product.price + "</td>\n" +
                    "                                        <td>" + product.amount + "<input type=\"hidden\" name=\"productid\" value=\"" + product.amount + "\"/></td>\n" +
                    "                                        <td>$ " + product.price * product.amount + "</td>\n" +
                    "                                    </tr>\n" +
                    "                                    <tr>");
            sum = sum + product.price * product.amount;
        }
        list.insertAdjacentHTML("beforeEnd", "<tr>\n" +
                "                                        <td colspan='3'></td>\n" +
                "                                        <td class=\"text-right\">Subtotal:</td>\n" +
                "                                        <td> $ " + sum + "<input type=\"hidden\" name=\"total\" value=\"" + sum + "\"/></td>\n" +
                "                                    </tr>\n" +
                "                                    <tr>\n" +
                "                                                <td colspan='3'></td>\n" +
                "                                                <td class=\"text-center\"colspan='2'>\n" +
                "                                                </td>\n" +
                "                                            </tr>");
    }
}

