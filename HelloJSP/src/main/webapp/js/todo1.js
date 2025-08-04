/**
 * todo1.js
 */
const students = [];

students.push({sname:"홍길동",score:"90"});
students.push({sname:"이길동",score:"120"});
students.push({sname:"김길동",score:"85"});

for(let i = 0; i < students.length;i++){
	if(students[i].score >= 100)
	console.log(`sname: ${students[i].sname}, score: ${students[i].score}`);

}
function showList(){
	
	students.forEach((elem,idx,ary)=>{
		let str =`<tr><td>${elem.sname}</td><td>${elem.score}</td></tr>`;
		document.querySelector('#tlist').innerHTML += str;
	});	
	
};

showList();

document.querySelector('#addList').addEventListener('click', () => {
	let sname = document.querySelector('#std_name').value; //''
	let score = document.querySelector('#std_score').value;
	

	//필수값 입력하세요
	if (id == '' || name == '' || point == '') {
		window.alert('필수값을 입력하세요!!');
		return;
	}
	document.querySelector('#list').innerHTML = '';
	//배열에추가
	students.push({ sname: name, score: score });
	showList();

	//입력값 초기화
	document.querySelector('#std_name').value = '';
	document.querySelector('#std_score').value = '';

})
	