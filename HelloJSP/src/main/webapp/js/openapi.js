/**
 * openapi.js
 */

//결과 목록을 활용해서 페이지 작성

let url = `https://api.odcloud.kr/api/15077586/v1/centers?page=1&perPage=248&serviceKey=v3TjaRBjC8VoESb0tRwdHrAnB7VRaH6pfgM3CFc%2BgX5ZvG%2BHS9CNs3tSHdmK%2FG97V9FQ1A05htMI2yimDos%2FfQ%3D%3D`;
		searchCenterList('대전광역시');

//검색창에 '광역시' 조회시 관련 '광역시'만 조회 

function searchCenterList(sido) {

	fetch(url)
		.then(resolve => resolve.json())
		.then(result => {
			const search = document.getElementById('search');
			
			result.data.forEach(elem => {
				if (elem.sido == sido) {  //매개값으로 비교하기
					//센터정보를 활용해서 tr>td*3 구조로 출력	
					let tr = document.createElement('tr');
					tr.addEventListener('click',function(e){
						window.open('daumapi.jsp?lat='+elem.lat+'&lng='+elem.lng);
					});
					//td 생성하기
					['id', 'centerName', 'phoneNumber']
						.forEach(prop => {
							let td = document.createElement('td');
							td.innerText = elem[prop];
							tr.appendChild(td);
						})
					// 생성한 trdmf tbody에 하위요소로 등록
					document.getElementById('list').appendChild(tr);
				}
			});
		})
		.catch(err => console.error(err));
		
}		
		
searchCenterList('서울특별시');	
