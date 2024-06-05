<html>
<head>
    <title>Menu</title>
</head>
<body>
<h1>Menu</h1>
<ul>
    <li>
        <form action="add-product" method="post">
            <label for="article">Article:</label>
            <input type="number" name="article" id="article" required><br>

            <label for="name">Name:</label>
            <input type="text" name="name" id="name" required><br>

            <label for="pageCount">Page Count:</label>
            <input type="number" name="pageCount" id="pageCount" required><br>

            <label for="price">Price:</label>
            <input type="number" step="0.01" name="price" id="price" required><br>

            <label for="quantity">Quantity:</label>
            <input type="number" name="quantity" id="quantity" required><br>

            <input type="submit" value="Add">
        </form>
    </li>
    <br>
    <li>
        <form action="edit-product" method="post">
            <label for="article">Article:</label>
            <input type="number" name="editArticle" id="editArticle" required><br>

            <label for="name">Name:</label>
            <input type="text" name="enewName" id="enewName" required><br>

            <label for="pageCount">Page Count:</label>
            <input type="number" name="epageCount" id="epageCount" required><br>

            <label for="price">Price:</label>
            <input type="number" step="0.01" name="enewPrice" id="enewPrice" required><br>

            <label for="quantity">Quantity:</label>
            <input type="number" name="enewQuantity" id="enewQuantity" required><br>

            <input type="submit" value="Edit">
        </form>
    </li>
    <br>
    <li><a href="print-inv">Print Inventory</a></li>
    <br>
    <form action="sell-product" method="post">
        <label for="saleArticle">Article:</label>
        <input type="text" name="saleArticle" id="saleArticle" required><br>

        <label for="saleQuantity">Quantity:</label>
        <input type="number" name="saleQuantity" id="saleQuantity" required><br>

        <input type="submit" value="Sell">
    </form>
    <br>
    <li><a href="print-sales">Print Sales</a></li>
</ul>
</body>
</html>
