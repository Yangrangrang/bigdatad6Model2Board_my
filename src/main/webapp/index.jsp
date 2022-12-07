<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
<%--    <link rel="stylesheet" href="<%=request.getContextPath()%>/public/bootstrap/css/bootstrap-grid.min.css">--%>
<%--    배포를 할때는 min을 써야함--%>
<%--    <script src="<%=request.getContextPath()%>/public/bootstrap/js/bootstrap.bundle.js"></script>--%>
</head>
<body>
    <%@include file="/headerNav.jsp"%>

    <h1>SPRING_BOARD 관리자 페이지</h1>
    <h2>깃 수업</h2>
    <h3>깃 시작하기</h3>
        <ol>
            <li>깃 저장소가 없는 위치 **에 프로젝트 폴더 생성</li>
            <li>해당 프로젝트에서 콘솔(git bash) 실행</li>
            <li>git status 로 깃 저장소가 아닌지 확인 (Not a git repository)</li>
            <li>git init : 깃 저장소 생성</li>
            <li>git confid user.name "이름" : 저장소의 주인 이름</li>
            <li>git confid user.emain sample@gmail.com : 저장소의 주인 이메일</li>
            <li>깃 원격 저장소의 계정과 동일하게 해야 인증이 편리하다</li>
            <li>프로젝트에 사용할 파일 생성</li>
            <li>git add . : staging area(index)에 생성한 파일을 추가</li>
            <li>git commit -m "멘트" : staging area에 등록된 파일의 스냅샷을 깃 저장소의 저장</li>
        </ol>
    <h3>깃의 staging area(index)와 상태</h3>
    <ul>
        <li>staging area(index) : 작업 이력을 깃 저장소에 스냅샷으로 등록하기 전에 처리해주는 곳</li>
        <li>
            git status : 작업 이력의 상태를 보는 명령어
            <ul>
                <li>Untracked files : staging area(index)에도 등록되지 않은 파일 (new file)</li>
                <li>Changes not staged for commit : 인덱스에 등록되지 않은 파일 (modified,deletegi)</li>
                <li>Changes to be committed : 인덱스에서 추적하는 파일 (커밋을 할 수 있는 상태)</li>
                <li>noting to commit, working tree clean : 작업이력과 저장소 이력이 동일</li>
                <li>Unmerged paths : 두 브랜치를 병합 (merge) 하던 중 충돌(CONFLICT) 을 일으키면 수정하라고 강제하는 파일</li>
            </ul>
        </li>
        <li>인덱스는 작업이력과 저장소의 이력을 수시로 검사하는 곳이다.</li>
        <li>이떄 작업 이력의 상태를 확인하는 명령어가 git status 이다.</li>
        <li>작업이력을 수정 (new, modify, delete)을 하면 저장소에 등록하기 전 인덱스에서 처리하는데 작업이력을 인덱스에 올리는 명령어가 git add 파일 </li>
        <li>git add 파일명 : 파일 하나를 인덱스에 추적</li>
        <li>git add . : 해당 폴더 하위의 모든 (숨김을 포함) 파일을 인덱스에서 추적</li>
        <li>git add * : 해당 폴더 하위의 모든 파일을 인덱스에서 추적(or 한번 저장소에 등록한 적이 있는 모든 파일을 추적)</li>\
        <li>인덱스에서 추적하는 파일을 수정된 이력을 스냅샷으로 저장소에 등록할 수 있는 데 이때 git commit -m " "을 사용한다.</li>
        <li>git commit -a -m "" : 한번 저장소에 등록되었던 파일은 git add *를 생략하고 저장소에 저장할 수 있다.</li>
    </ul>
    <h3>git diff로 어떤 작업 이력이 수정되었는지 확인</h3>
    <ul>
        <li>git diff : 작업 폴더의 작업 내역과 저장소의 이력을 비교해서 표시(unstaged)</li>
        <li>git diff --staged(cached) : 인덱스의 작업내역과 저장소의 이력을 비교해서 표시(staged)</li>
    </ul>
    <h3>(git commit 으로 저장소 등록)</h3>
    <ul>
        <li>git commit이라는 명령어는 인덱스에서 수정된 작업 이력을 저장소의 저장하는 명령어</li>
        <li>인덱스에서 저장하는 내역은 링크나 수정된 내역의 스냅샷으로 고유번호로 무결성을 지킨다.(앞의 7자리 만으로 동작)</li>
        <li>파일은 인덱스에서 추적하지 않으면 절대 저장소에 저장할 수 없으며 한번 저장된 파일은 "=a" 옵션으로 인덱스 등록및 저장 가능하다.</li>

    </ul>
</body>
</html>