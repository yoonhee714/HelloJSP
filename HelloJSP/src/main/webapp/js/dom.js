/**
 * dom.js
 * <ul id="target">
	<li>apple</li>
	<li>banana</li>
	</ul>
	Document object Model
 */
let ul = document.createElement('ul');// <ul/>
ul.setAttribute('id','target');

let li = document.createElement('li');
li.innerText = 'apple';
ul.appendChild(li);

//banana 추가
let li = document.createElement('li');
li.innerText = 'banana';
ul.appendChild(li);

console.log(ul); // <ul id='target'><li>apple</li><li>banana</li></ul>

// <div id = 'show' />
document.querySelector('#show').appendChild(ul);

