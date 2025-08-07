/**
 * board.js
 * 144 댓글 정보 -> json 반환
 */

//호출
//svc.increaseCount(); 
//console.log(svc.showCount());


let page = 1; //page 변경
//페이지로딩시점 실행	
fetch('replyList.do?bno=' + bno)
	.then(function(resolve) {
		return resolve.json(); //fetch의 결과없이 readableStream
	})
	.then(function(result) {
		console.log(result);
		result.forEach(reply => {
			let li = makeRow(reply);
			document.querySelector('div.content>ul').appendChild(li);
		})
	})
	.catch(function(err) {
		console.log(err);
	});

function showReplyList() {
	//기존목록을 지우고,
	document.querySelectorAll('div.content>ul>li').forEach((elem, idx) => {
		console.log(elem, idx);
		if (idx >= 2) {
			elem.remove();
		}
	});

	//목록 출력	
	svc.replyList({ bno, page }, //첫번째 param
		result => {
			result.forEach(reply => {
				let target =document.querySelector('div.content>ul');
				let text = `<li>
								<span class="col-sm-2">${reply.replyNo}</span>
								<span class="col-sm-5">${reply.reply}댓글입니다</span>
								<span class="col-sm-2">${reply.replyer}</span>
								<span class="col-sm-2"><button onclick='deleteRowFnc(event)'>삭제</button></span>
							</li>`;
				target.insertAdjacentHTML('beforeend', text); //ppsition,text
				//let li = makeRow(reply);
				//document.querySelector('div.content>ul').appendChild(li);
			})
			//페이지목록
			showPagingList();
		}, //두번째 param
		err => console.log(err)	//세번째 param		
	);

}

showReplyList();



//페이징목록 출력
function showPagingList() {

	svc.replyTotalCount(bno,
		result => {
			console.log(result);
			let totalCnt = result.totalCnt; //80
			let paging = new PageVO(page, totalCnt);
			console.log(paging);

			//parent 요소
			let target = document.querySelector('div.pagination');
			target.innerHTML = ''; //기존목록삭제

			//이전페이지 여부
			if (paging.prev) {
				let atag = document.createElement('a');
				atag.href = paging.start - 1;
				atag.setAttribute('data-page', paging.start - 1);
				atag.innerHTML = '&laquo;'
				target.appendChild(atag);
			}
			//start ~ end
			for (let p = paging.start; p <= paging.end; p++) {
				let atag = document.createElement('a');
				atag.href = p; //atag.setAttribute('href', p); //<a href="3">
				atag.setAttribute('data-page', p);
				atag.innerText = p;
				target.appendChild(atag);
			}
			//이후 페이지
			if (paging.next) {
				let atag = document.createElement('a');
				atag.href = paging.end + 1;
				atag.setAttribute('data-page', paging.start + 1);
				atag.innerHTML = '&raquo;'
				target.appendChild(atag);
			}
			// a 태그에 클릭이벤트.
			addEvent();
		},
		err => console.log(err)
	);
}



//이벤트 등록 
document.querySelector('#addReply')
	.addEventListener('click', function(e) {
		//게시글번호(bno)/작성자(logid)/댓글(reply)
		let reply = document.querySelector('#reply').value;

		if (!bno || !reply || !logId) { //true/false =>falsy(0,'',null,undefind)}
			alert('필수값을 입력');
		}


		svc.registerReply({ bno, reply, replyer: logId },
			result => {
				console.log(result);
				if (result.retCode == 'OK') {
					let r = result.retVal;
					let li = makeRow(r);
					document.querySelector('div.content>ul').appendChild(li);
					document.querySelector('#reply').value = '';
				} else if (result.retCode == 'NG') {
					alert('처리중 예외발생 ');
				} else {
					alert('알 수없는 코드');
				}
			}, //2번째 파라미터
			err => console.log(err) //3번째 파라미터
		);
	})



//페이징 링크에 클릭이벤트
function addEvent() {
	document.querySelectorAll('div.footer>div.pagination>a')
		.forEach(atag => {
			atag.addEventListener('click', e => {
				e.preventDefault(); //기본기능을 차단
				page = e.target.dataset.page; // data-page => dataset.page	
				console.log(page);
				//목록그려주기
				showReplyList();
			})
		})
}



//댓글정보를 활용해서 li>span 구조를 만들기	
function makeRow(reply) {

	let li = document.createElement('li');

	//화면에 출력할 정보를 배열로 선언
	['replyNo', 'reply', 'replyer'].forEach(elem => {
		let span = document.createElement('span');
		span.innerText = reply[elem];
		if (elem == 'reply') { //댓글내용은 너비를 다르게 설정함
			span.setAttribute('class', 'col-sm-5');
		} else { //나머지는 col-sm-2
			span.setAttribute('class', 'col-sm-2');
		}
		li.appendChild(span);
	});//반복

	//삭제
	let span = document.createElement('span');
	span.setAttribute('class', 'col-sm-2');
	let btn = document.createElement('button');
	btn.addEventListener('click', deleteRowFnc);

	btn.innerText = '삭제';
	span.appendChild(btn);
	li.appendChild(span);

	//생성한 li 반환
	return li;
} //end of makerow 

//데이터 삭제 이벤트 핸들러
function deleteRowFnc(e) {
	let rno = e.target.parentElement.parentElement.children[0].innerText;
	rno= e.target.closest('li').firstElementChild.innetText;
	if (!confirm(`${rno}번 글을 삭제하겠습니까?`)) {
		alert('삭제를 취소했습니다.');
		return;
	}
	//fetch 서버프로그램 호출
	svc.removeReply(rno,
		result => {
			if (result.retCode == 'OK') {
				e.target.parentElement.parentElement.remove();
				showReplyList();
			} else if (result.retCode == 'NG') {
				alert('삭제실패!!');
			} else {
				alert('알수없는 코드입니다.');
			}
		},
		err => console.log(err)
	);
}
