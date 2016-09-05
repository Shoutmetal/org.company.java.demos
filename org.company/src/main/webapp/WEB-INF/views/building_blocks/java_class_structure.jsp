<ol class="breadcrumb">
	<li><a href="../">Home</a></li>
	<li><a href="../building_blocks/index">Building Blocks</a></li>
	<li class="active">Define the structure of a Java class</li>
</ol>
<div class="container">
	<article>
		<h1>Understanding the Java Class Structure</h1>
		<p>
			In Java Programs, classes are the basic building blocks. When
			defining a <b><i>class</i></b>, you describe all the parts and
			characteristics of one of those building blocks. To use most classes,
			you have to create objects. An <b><i>Object</i></b> is a runtime
			instance of a class in memory. All the various objects of all the
			different classes represents the state of your program.
		</p>
		<section>
			<h2>Fields and Methods</h2>
			<p>
				Java classes have two primary elements: <b><i>methods</i></b>, often
				called functions or procedures in other languages, and <b><i>fields</i></b>,
				more generally known as variables. Together these are called <b><i>members</i></b>
				of a class.
			</p>
			<figure>
				<pre>
					<code class="language-csharp" data-lang="csharp">
						public class Animal {}
					</code>
					
				</pre>
				
			</figure>
			
			<div class="clearfix"></div>
			<p>
			The <b><i>public</i></b> keyword means the class can be used by other classes. The <b><i>class</i></b> keyword
			indicates you're defining a class <b><i>Animal</i></b> gives the name of the class.
			</p>
			 <figure>
				<pre>
					<code class="language-csharp" data-lang="csharp">
						public class Animal {
							String name;
						}
					</code>
				</pre>
			</figure>
			
		</section>

	</article>






</div>