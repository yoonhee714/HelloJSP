/**
 * basic2.js
 */
const fruits = ['apple', 'banana', 'cherry']; //new array();
fruits[3] = 'orange';

//추가, 삭제
fruits.push('melon');
fruits.unshift('mango');
fruits.pop(); //melon 제거
fruits.pop(); //orange 제거
fruits.shift(); //mango 제거
fruits.shift(); //apple 제거


for (let fruit of fruits) {
	console.log(fruit);
}


const members = [{ id: 'user01', name: 'Hong', point: 100 }];
members.push({ id: 'user02', name: 'Park', point: 120 });
members.push({ id: 'user03', name: 'Kim', point: 90 });

for (let i = 0; i < members.length; i++) {
	if (members[i].point >= 100)
		console.log(`id: ${members[i].id}, name: ${members[i].name}, point: ${members[i].point}`);
}
//화면에 배열의 갯수만큼 회원정보를 출력하는 함수
function showList() {


	//반복문.forEach (배열메소드)
	members.forEach((elem, idx, ary) => {
		let str = `<li>아이디: ${elem.id}, 이름:${elem.name}, 포인트:${elem.point}</li>`;
		//ul요소
		document.querySelector('#list').innerHTML += str;

		//if(elem.point >= 100)
		//console.log(`id: ${elem.id}, name: ${elem.name}, point: ${elem.point}`);
	});
};//end of showList()

showList();

//이벤트
document.querySelector('#addBtn').addEventListener('click', () => {
	let id = document.querySelector('#mid').value; //''
	let name = document.querySelector('#mname').value;
	let point = document.querySelector('#point').value;

	//필수값 입력하세요
	if (id == '' || name == '' || point == '') {
		window.alert('필수값을 입력하세요!!');
		return;
	}
	document.querySelector('#list').innerHTML = '';
	//배열에추가
	members.push({ id: id, name: name, point: point });
	showList();

	//입력값 초기화
	document.querySelector('#mid').value = '';
	document.querySelector('#mname').value = '';
	document.querySelector('#point').value = '';
})
