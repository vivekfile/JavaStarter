function loadProducts() {

    fetch("http://localhost:8080/products")

        .then(response => response.json())

        .then(products => {

            let output = "";

            products.forEach(product => {

                output += `

                <div class="card">

                    <img src="https://picsum.photos/300/200?random=${product.id}" alt="Product">

                    <h2>${product.name}</h2>

                    <p class="id">Product ID : ${product.id}</p>

                    <p class="price">₹ ${product.price}</p>

                    <button class="buy">
                        Buy Now
                    </button>

                </div>

                `;

            });

            document.getElementById("products").innerHTML = output;

        });

}