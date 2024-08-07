<div align="center">
<img src="https://capsule-render.vercel.app/api?type=waving&color=EDE7DF&height=200&width=100%&section=header&text=StoryWave&fontSize=130&center=true" />
</div>


<p align="center">
  <img src="https://readme-typing-svg.demolab.com/?lines=Beyond+the+genre,+a+space+that+opens+up+a+create+perspective!&font=Fira%20Code&&color=black&center=true&width=800&height=50&duration=4000&pause=1000" alt="Example Usage - README Typing SVG">
</p>
<br>
<br>

###   HOW ABOUT AS
  🐰 팀원 . 박예린 <br><br>
  🐿️ 팀원 . 김주영 <br><br>
  🐻 팀장 . 노유진 <br><br>
  🐶 팀원 . 문석준 <br><br>
  🦁 팀원 . 박준호 <br><br><br>
### OUR PROJECT
    "가끔은 느리게 가는 것도 좋은 것 같다. <br>            영화와 책에 대한 진지하고 또 가벼운 크고 작은 이야기를 나누는,<br>            장르를 넘어서 새로운 시각을 만드는 공간."<br><br>
### SKILLS 
  <img src="https://img.shields.io/badge/HTML-E34F26?style=flat-square&logo=html5&logoColor=white"/>
<img src="https://img.shields.io/badge/CSS-1572B6?style=flat-square&logo=css3&logoColor=white"/>
<img src="https://img.shields.io/badge/Java-007396?style=flat-square&logo=java&logoColor=white"/></a>
<img src="https://img.shields.io/badge/JavaScript-F7DF1E?style=flat-square&logo=javascript&logoColor=white"/></a>
<img src="https://img.shields.io/badge/Spring-6DB33F?style=flat-square&logo=spring&logoColor=white"/></a>
<img src="https://img.shields.io/badge/thymeleaf-%23005F0F.svg?&style=flat-square&logo=thymeleaf&logoColor=white" />


### ERD

![image](https://github.com/user-attachments/assets/c3e922f6-65ff-4f54-b52b-619fbc74b03f)

<br></br>

### 요구사항 명세서
#### 회원 관리 기능
| id | 권한 | 요구사항명 | 요구사항 상세 내용 | 필수여부 | 비고(논의사항) |
| --- | --- | --- | --- | --- | --- |
| 1 | 공통 | 로그인 | 아이디와 비밀번호가 일치하면 로그인을 허용한다. | 필수 | 카카오 api를 사용할건지(조사 필요)
| 1 | 공통 | 로그인 | 로그인 성공 시 상단에 로그인/회원가입이 마이페이지로 변경된다. | 필수 |
| 2 | 공통 | 회원가입 | 아이디, 비밀번호, 비밀번호 확인, 이메일, 닉네임 항목을 입력한다.
| 2 | 공통 | 회원가입 | 아이디, 이메일, 닉네임은 중복 여부를 확인한다.
| 2 | 공통 | 회원가입 | 비밀번호와 비밀번호 확인란이 일치해야 한다.
| 2 | 공통 | 회원가입 | 해당 조건을 모두 만족하면 회원가입에 성공한다. | 필수 | 회원가입 성공 후 회원가입 성공 페이지 보여주기(하단에 로그인 링크 걸어두기)
| 3 | 공통 | 아이디 찾기 | 선택 |  |
| 4 | 공통 | 비밀번호 찾기 | 선택 |  |

<br></br>

#### 게시물 조회 기능 (영화)
| id | 권한 | 요구사항 상세 내용 | 필수여부 | 비고(논의사항) |
| --- | --- | --- | --- | --- |
| 5 | 공통 | 영화 페이지에서 전체 게시물을 조회한다.
| 5 | 공통 | 카테고리를 선택하면 해당 카테고리에 해당하는 게시물만을 조회한다.
| 5 | 공통 | 영화 카테고리에는 >액션, 코미디, 범죄스릴러, 공포, 로맨스, 애니, SF/판타지, 다큐멘터리>가 있다.
| 5 | 공통 | 번호, 제목, 작성자, 작성날짜, 공감 수, 댓글 수가 게시물 목록에 나타난다. | 필수 | 카테고리 중복 선택이 가능하다.
| 5 | 공통 | 카테고리 전체가 추가되고 취소되는 버튼 추가 필요
| 5 | 공통 | 조회는 로그인을 하지 않아도 가능하다.
| 5 | 공통 | 조회를 할 때 목록 안에서 페이지가 존재한다.
| 5 | 공통 | 글쓰기 작성 페이지로 넘어갈 수 있는 버튼이 존재한다.
| 5 | 공통 | 목록 최상단에 최신 공지사항 5개를 보여준다(목록번호에 해당되지 않는다).
| 5 | 공통 | 최신순, 인기순(따봉순)으로 조회하는 기능 추가(선택) |

<br></br>

#### 게시물 조회 기능 (도서)
| id | 권한 | 요구사항 상세 내용 | 필수여부 | 비고(논의사항) |
| --- | --- | --- | --- | --- |
| 6 | 공통 | 미로그인 시 로그인 페이지로 넘어간다.
| 6 | 공통 | 도서 페이지에서 전체 게시물을 조회한다.
| 6 | 공통 | 카테고리를 선택하면 해당 카테고리에 해당하는 게시물만을 조회한다.
| 6 | 공통 | 도서 카테고리에는 <소설/시, 에세이, 인문, 경제/경영, 기타>가 있다.
| 6 | 공통 | 번호, 제목, 작성자, 작성날짜, 공감 수, 댓글 수가 게시물 목록에 나타난다. | 필수 | 카테고리 중복 선택이 가능하다.
| 6 | 공통 | 카테고리 전체가 추가되고 취소되는 버튼 추가 필요
| 6 | 공통 | 로그인이 되어있어야지만 조회가 가능하다.
| 6 | 공통 | 조회를 할 때 목록 안에서 페이지가 존재한다(한 페이지에 10개씩 게시물을 보여준다).
| 6 | 공통 | 글쓰기 작성 페이지로 넘어갈 수 있는 버튼이 존재한다.
| 6 | 공통 | 목록 최상단에 최신 공지사항 5개를 보여준다(목록번호에 해당되지 않는다).
| 6 | 공통 | 최신순, 인기순(따봉순)으로 조회하는 기능 추가(선택) |

<br></br>

#### 게시물 작성 및 상세 조회 기능
| id | 권한 | 요구사항명 | 요구사항 상세 내용 | 필수여부 | 비고(논의사항) |
| --- | --- | --- | --- | --- | --- |
| 7 | 일반/관리자 | 게시물 작성 | 제목, 내용이 모두 적혀있어야지만 저장이 가능하다. | 필수 | 저장 후 작성한 게시글 화면으로 넘어간다(게시물 상세 조회 페이지).
| 7 | 일반/관리자 | 게시물 작성 | 카테고리 중복 선택이 가능하다.
| 7 | 일반/관리자 | 게시물 작성 | 로그인해야지만 댓글을 작성할 수 있다. |
| 8 | 일반/관리자 | 게시물 상세 조회 | 게시물 목록 중 게시물을 선택했을 때 해당 페이지로 이동할 수 있다.
| 8 | 일반/관리자 | 게시물 상세 조회 | 제목, 작성자, 작성날짜, 내용, 공감수, 댓글 수가 보인다.
| 8 | 일반/관리자 | 게시물 상세 조회 | 페이지 내에 공감 버튼을 통해 해당 게시물을 공감할 수 있다.
| 8 | 일반/관리자 | 게시물 상세 조회 | 해당 게시물에 대한 댓글을 볼 수 있다. | 필수 | 로그인 시에만 상세 조회가 가능하다.

<br></br>

#### 게시물 삭제 및 수정 기능
| id | 권한 | 요구사항명 | 요구사항 상세 내용 | 필수여부 | 비고(논의사항) |
| --- | --- | --- | --- | --- | --- |
| 9 | 일반 | 게시물 수정 | 게시물 화면에서 본인 게시물만 수정할 수 있다. | 필수 | 본인 게시물이 아닐 시에는 수정 버튼이 비활성화된다.
| 9 | 일반 | 게시물 수정 | 로그인이 되어있고 본인 게시물만 수정할 수 있다. |
| 10 | 일반 | 게시물 삭제 | 게시물 화면에서 본인 게시물만 삭제가 가능하다. | 필수 | 본인 게시물이 아닐 시에는 삭제 버튼이 비활성화된다.
| 10 | 일반 | 게시물 삭제 | 로그인이 되어있고 본인 게시물만 삭제할 수 있다.
| 10 | 일반 | 게시물 삭제 | 삭제 모달창이 뜨고 삭제하기 클릭 시에 게시물이 삭제된다.
| 10 | 일반 | 게시물 삭제 | 삭제된 후에는 전체 게시물 목록으로 이동 |
| 11 | 관리자 | 게시물 삭제 | - 게시물 화면에서만 삭제가 가능하다.
| 11 | 관리자 | 게시물 삭제 |  관리자 로그인이 되어있어야하고 전체 게시물 삭제가 가능하다. | 필수 | 관리자에게는 삭제 버튼이 활성화되어있다.

<br></br>

#### 댓글 기능
| id | 권한 | 요구사항명 | 요구사항 상세 내용 | 필수여부 | 비고(논의사항) |
| --- | --- | --- | --- | --- | --- |
| 12 | 일반/관리자 | 댓글 작성 | 특정 게시물에 대한 댓글을 작성할 수 있다.
| 12 | 일반/관리자 | 댓글 작성 | 로그인해야지만 댓글을 작성할 수 있다.
| 12 | 일반/관리자 | 댓글 작성 | 작성 시 닉네임과 댓글내용과 작성시간을 보여준다. | 필수 |
| 13 | 일반 | 댓글 수정/삭제 | 로그인이 되어있고 본인 댓글인 경우에는 댓글 수정 및 삭제가 가능하다.
| 13 | 일반 | 댓글 수정/삭제 | 댓글에 내용이 적혀있지 않으면 수정이 되지 않는다. |  | 댓글 수정/삭제 버튼은 본인 댓글일때만 활성화된다.
| 13 | 일반 | 댓글 수정/삭제 | 댓글 수정 시 동일한 페이지 내에서 수정한다. |
| 14 | 관리자 | 댓글 삭제 |  관리자 로그인이 되어있어야 하고 전체 댓글 삭제가 가능하다. |  | 관리자에게는 댓글 삭제 버튼이 활성화되어있다.
| 14 | 관리자 | 댓글 삭제 |  댓글 삭제 모달창이 뜨고 삭제하기 클릭 시에 댓글이 삭제된다.
| 14 | 관리자 | 댓글 삭제 |  삭제된 후에 현재 게시물에 그대로 있는다. |
| 15 | 일반/관리자 | 공감 표시 |  특정 게시물에 대한 공감을 표시할 수 있다.
| 15 | 일반/관리자 | 공감 표시 |  로그인해야지만 사용할 수 있다. | 필수(우선순위는 낮음) |  | 공감 버튼 클릭 시 공감 수가 카운트되어야 한다.
| 15 | 일반/관리자 | 공감 표시 |  공감 버튼은 다시 취소할 수 없다. |

<br></br>

#### 게시물 검색 기능
| id | 권한 | 요구사항명 | 요구사항 상세 내용 | 필수여부 | 비고(논의사항) |
| --- | --- | --- | --- | --- | --- |
| 16 | 일반 | 게시물 검색(통합) | 검색어가 포함된 게시물을 전부 보여준다. | 필수 | 검색목록에 공지사항을 포함한다.
| 16 | 일반 | 게시물 검색(통합) | 제목에 검색어가 포함되면 모두 반환한다.
| 16 | 일반 | 게시물 검색(통합) | 검색어가 포함된 제목 대한 게시물을 최신순으로 반환한다.
| 16 | 일반 | 게시물 검색(통합) | 공지사항, 영화, 도서 순으로 반환한다.
| 16 | 일반 | 게시물 검색(통합) | 검색은 로그인을 하지 않아도 가능하다. |
| 17 | 일반 | 게시물 검색(페이지 내) | 영화/도서 페이지 내에서 검색어가 포함된 게시물을 전부 보여준다. | 선택 | 제목, 전체 항목을 선택해서 검색 가능하다.
| 17 | 일반 | 게시물 검색(페이지 내) | 로그인 시에만 검색이 가능하다.
| 17 | 일반 | 게시물 검색(페이지 내) | 미로그인 시에 로그인 페이지를 보여준다. |

<br></br>

#### 마이페이지
| id | 권한 | 요구사항명 | 요구사항 상세 내용 | 필수여부 | 비고(논의사항) |
| --- | --- | --- | --- | --- | --- |
| 18 | 일반 | 마이페이지 | - 로그인이 되어있어야지만 마이페이지를 보여준다.
| 18 | 일반 | 마이페이지 | 미로그인 시 로그인 페이지로 넘어간다.
| 18 | 일반 | 마이페이지 | 내 게시물, 내 댓글, 회원정보 수정, 탈퇴하기가 있다. | 필수 |
| 19 | 일반 | 내 게시물 조회 | - 마이페이지의 <내 게시물> 버튼을 통해서만 기능 수행이 가능하다.(로그인 시에만 가능)
| 19 | 일반 | 내 게시물 조회 | 내가 작성한 게시물 전체를 조회한다.
| 19 | 일반 | 내 게시물 조회 | 전체 게시물 조회와 동일하게 번호, 제목, 작성자, 작성날짜, 공감 수, 댓글 수를 확인할 수 있다.
| 19 | 일반 | 내 게시물 조회 | 특정 게시물을 선택할 시 게시물 상세 페이지로 이동한다. | 필수 | 조회를 할 때 페이지를 넘어가도록 구현할건지? 그냥 밑으로 끝없이 스크롤하는 형식으로 구현할건지?
| 19 | 일반 | 내 게시물 조회 | 최신순, 인기순(따봉순)으로 조회하는 기능을 시간이 남으면 추가 |
| 20 | 일반 | 내 댓글 조회 | 마이페이지의 <내 댓글> 버튼을 통해서만 기능 수행이 가능하다.(로그인 시에만 가능)
| 20 | 일반 | 내 댓글 조회 | 내가 작성한 댓글 전체를 조회한다.
| 20 | 일반 | 내 댓글 조회 | 번호, 제목, 작성자, 작성날짜를 확인할 수 있다.
| 20 | 일반 | 내 댓글 조회 | 특정 게시물을 선택할 시 게시물 상세 페이지로 - 이동한다. | 필수 | 대댓글 기능 추가 시에만 댓글 수를 제공함(선택)
| 20 | 일반 | 내 댓글 조회 | 공감 수를 제공하기 위해서는 댓글에 공감표시 기능을 추가해야함(선택) |
| 21 | 일반 | 회원 정보 수정 | - 마이페이지의 <회원 정보 수정> 버튼을 통해서만 기능 수행이 가능하다.
| 21 | 일반 | 회원 정보 수정 | 아이디를 제외한 비밀번호, 이메일, 닉네임을 수정할 수 있다.
| 21 | 일반 | 회원 정보 수정 | 공백으로 제출할 수 없다. | 필수 |  | - 공백으로 제출할 수 없다. |
| 22 | 일반 | 탈퇴하기 | 마이페이지의 <탈퇴하기> 버튼을 통해서만 기능 수행이 가능하다.
| 22 | 일반 | 탈퇴하기 | 탈퇴 여부를 다시 물어보고 ‘탈퇴하기’ 선택 시에 탈퇴가 된다.
| 22 | 일반 | 탈퇴하기 | 탈퇴 성공 시에 회원 정보와 작성된 게시물, 댓글이 모두 삭제된다. | 필수 | 탈퇴 성공 시 ‘정상적으로 탈퇴되었습니다.’ 페이지를 보여준다(홈으로 가는 버튼으로 이어짐). |

<br></br>

#### 관리자 권한 기능
| id | 권한 | 요구사항명 | 요구사항 상세 내용 | 필수여부 | 비고(논의사항) |
| --- | --- | --- | --- | --- | --- |
| 23 | 관리자 | 회원 정지 | 관리자는 회원 정지를 할 수 있다.
| 23 | 관리자 | 회원 정지 |  정지 기간을 설정할 수 있다.
| 23 | 관리자 | 회원 정지 |  정지 사유를 작성해야한다. |  | 관리자일 때 작성자 이름이 버튼(링크)으로 활성화된다. 
| 23 | 관리자 | 회원 정지 |  정지 회원, 기간, 사유를 작성하여 회원을 정지한다(모달창 활용)
| 23 | 관리자 | 회원 정지 |  정지 회원명은 자동으로 입력되어있고 수정할 수 없다.
| 23 | 관리자 | 회원 정지 |  기간은 7일, 15일, 30일, 무기한으로 설정할 수 있다. |
| 24 | 관리자 | 관리자 페이지 | - 관리자만 사용할 수 있는 관리자 페이지가 있다. |  | 마이페이지 항목에 회원 목록을 볼 수 있는 항목 추가된다. 
| 24 | 관리자 | 관리자 페이지 | 회원 목록 조회(회원 id, 닉네임, 작성한 게시물 수, 작성한 댓글 수, 정지 여부)
| 24 | 관리자 | 관리자 페이지 | 전체, 활동정지회원 선택해서 볼 수 있다.
| 24 | 관리자 | 관리자 페이지 | 이름 클릭하면 동일하게 정지 모달창이 뜨고 회원 정지를 할 수 있다.
| 24 | 관리자 | 관리자 페이지 | 정지 회원을 해제할 수도 있다. |
| 25 | 관리자 | 공지사항 작성 | - 로그인이 되어있어야지 게시글 작성 페이지로 넘어갈 수 있다.
| 25 | 관리자 | 공지사항 작성 |  미로그인 시 로그인 페이지로 넘어간다.
| 25 | 관리자 | 공지사항 작성 |  로그인이 되어있으면 게시글을 작성한다.
| 25 | 관리자 | 공지사항 작성 |  제목, 내용이 모두 적혀있어야지만 저장이 가능하다. |  | 공지사항 글쓰기 버튼은 관리자에게만 활성화된다. |
| 26 | 정지 | 로그인 |  아이디와 비밀번호 입력 시 로그인이 된다. |  | 정지 회원의 경우 공지사항만 조회 가능하다.
| 26 | 정지 | 로그인 |  게시물 조회, 작성, 댓글 작성이 불가하다.
| 26 | 정지 | 로그인 |  “정지 회원입니다. 게시물 작성과 댓글 작성이 제한됩니다. (사유: ….)” 가 적힌 모달창을 보여준다.
| 26 | 정지 | 로그인 |  영구 정지의 경우 “영구 정지 회원입니다. (사유: …)”가 적힌 모달창을 보여주고 로그인이 실패된다. |

<br></br>

### 📃 API 명세서
| 카테고리 | 요구사항명 | Method | url |
| --- | --- | --- | --- |
| login | 로그인 | GET | /user/login |
| login | 로그아웃 | GET | /user/logout |
| 회원 가입 | 회원 가입 | POST | /user/join |
| 회원 가입 | 아이디 찾기 |  |  |
| 회원 가입 | 비밀번호 찾기 |  |  |
| 회원 가입 | 회원 정보 수정 |  | /mypage/update-user |
| 회원 가입 | 탈퇴하기 | DELETE |  |
| board | 게시물 조회 | GET | post/{post_type_id} |
| board | 게시물 작성 | POST | post/{post_type_id} |
| board | 게시물 상세 조회 | GET | /post/{post_type_id}/{postId} |
| board | 게시물 수정 | PUT |  |
| board | 게시물 삭제 | DELETE | /post/{post_type_id}/{postId} |
| comment | 댓글 작성 | POST | api/post/{postId}/comments |
| comment | 댓글 조회 | GET | api/post/{postId}/comments |
| comment | 댓글 수정 | PUT | api/post/{postId}/comments/{commentId} |
| comment | 댓글 삭제 | DELETE | api/post/{postId}/comments/{commentId} |
| board | 공감 표시 | POST | /{postId}/like |
| user | 마이페이지 | GET | /userMyPage  (/mypage 가능) |
| user | 내 게시물 조회 | GET | /mypage/mypost |
| user | 내 댓글 조회 | GET | /mypage/mycomment |
| admin | 회원 정지 | GET | /userList |
| admin | 회원 목록 | GET | /adminMypage |
| admin | 관리자 마이페이지 | GET | /adminmypage    (/mypage 가능) |
| admin | 관리자 페이지 | GET | /adminmypage |
| search | 게시물 검색(통합) | GET | /board/search |






















