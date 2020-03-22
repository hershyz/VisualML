<h1>VisualML</h1>
<p>VisualML is a Java library used to make predictions based on existing data.</p>

<h3>Setting up your data:</h3>
<p>A data file must have three parameters in every line, seperated by a <code>, </code>.</p>
<p>The first parameter is an X value, the second is a Y value, and the third parameter is the category the respective point falls under.</p>
<p>For example:</p>
<code>1, 2, category1</code>
<br>
<code>4, 1, category2</code>
<br>
<br>

<h3>Importing and making predictions:</h3>
<p>Import VisualML in your project like so, a data filepath must be specified:</p>
<code>VisuaML visualML = new VisualML("data.txt");</code>
<br>
<p>Read the raw data in the file and set the length of arrays:</p>
<code>visualML.readRaw();</code>
<code>visualML.setArrays();</code>
<code>visualML.setCategoryArray();</code>
<br>
<p>Load the X, Y, and category values into respective arrays:</p>
<code>visualML.loadX();</code>
<code>visualML.loadY();</code>
<code>visualML.loadCategories();</code>
<br>
<p>Make a prediction with a new data point based on loaded data:</p>
<code>String predictedCategory = visualML.predict(x, y);</code>
<br>
<br>

<h3>Example:</h3>
<img src="images/Screenshot (28).png"></img>
<p>The different colored dots represent different categories in the existing data.</p>
<img src="images/Screenshot (30).png"></img>
<p>The black dot represents the point that a prediction is based on, since it is closest to the red point (1, 2), the program predicts that the black dot falls under the category of red points.</p>
