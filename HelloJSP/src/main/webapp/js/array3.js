/**
 * array3.js
 */

let studentAry = [
	{ name: "홍길동", score: 80 },
	{ name: "김민규", score: 85 },
	{ name: "박흥부", score: 88 },
	{ name: "김길동", score: 77 }
]

let result = studentAry.reduce((acc, elem) => {
	let tr = document.createElement('tr');
	for(let prop in elem){
		let td = document.createElement('td');
		td.innerText = elem[prop];
		tr.appendChild(td);
	}
	acc.appendChild(tr);
	return acc;
}, document.querySelector('#item tbody'));	





let numAry = [10, 15, 34, 77, 20, 25, 30]
 result = numAry.reduce((acc, elem, idx, ary) => {  //reduce 반복 acc값은 elem 이전의 값
	console.log(`${acc}, ${elem}`);
	// acc => [10]
	if(elem % 2 == 0){
		acc.push(elem);
	}
	return acc; // [10, 34]
//	return acc > elem ? acc : elem;
},[]);
console.log(result);

//let result = studentAry.reduce((acc, elem) => {
//	console.log('acc=> ', acc,'elem=> ', elem);
//	if(acc.score < elem.score){
//		acc = elem;
//	}
//	return acc;
//},studentAry[0]);
//console.log(`최고득점자는 ${result.name}, 점수는 ${result.score}점입니다.`); //최고득점자는 박흥부, 점수는 88점입니다.

//let result = studentAry.reduce((acc, elem) => {
//	if(elem.score >= 80){
//		acc.push(elem);
//	}
//	return acc;
//},studentAry[]);
//console.log(result); //80점이상 득점자