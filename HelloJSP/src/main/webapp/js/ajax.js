/**
 * ajax.js
 * Asychronous Javascript And Xml
 */

//동기방식 VS 비동기 방식


//비동기방식(setTimeout; 시간을 두고 실행)
setTimeout(function(){
	console.log('1');
}, 1000);

setTimeout(function(){
	console.log('2');
}, 2000);

setTimeout(function(){
	console.log('3');
}, 500);

const xhtp = new XMLHttpRequest();



//동기방식
setTimeout(function(){
	console.log('1'); 
	
	setTimeout(function(){
		console.log('2');
	
		setTimeout(function(){
			console.log('3');
			
			}, 500);
		}, 2000);
}, 1000);





