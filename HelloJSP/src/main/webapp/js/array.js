/**
 * array.js (forEach, map, filter, reduce)
 * document,querySelectorAll();

members.forEach((elem, idx, ary) => {
	if(idx == ary.length - 1) {
		console.log(elem);
	}
});

*/

// const totalSum = (elem, idx, ary) => {}

let sum = 0;
//[12, 34, 83, 22, 59, 77].forEach((elem) => {});
//evenSum, oddSum, totalSum
var evenSum = (elem, idx, ary) => {
	if(idx % 2 == 0){
			sum += elem;
}
	if(idx == ary.length - 1){
		console.log(`짝수의 합계는 ${sum}`);
	}
}
var oddSum = (elem, idx, ary) => {
	if(idx % 2 == 0){
			sum += elem;
}
	if(idx == ary.length - 1){
		console.log(`홀수의 합계는 ${sum}`);
	}
}
var totalSum = (elem, idx, ary) => {
	sum += elem;
		if(idx == ary.length - 1){
			console.log(`합계는 ${sum}`);
		}		
}
[12, 34, 83, 22, 59, 77].forEach(totalSum);		