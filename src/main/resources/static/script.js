function loadProducts() {

    fetch("http://localhost:8080/products")

        .then(response => response.json())

        .then(products => {

            let output = "";

            products.forEach(product => {

                output += `
                    <div class="card">

                        <h2>${product.name}</h2>

                        <p>ID : ${product.id}</p>

                        <p>Price : ₹${product.price}</p>

                    </div>
                `;

            });

            document.getElementById("products").innerHTML = output;

        });

}