<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<script type="text/javascript">
	alert('no : ${ sessionScope.no } 게시글이 수정되었습니다');
	location.href = 'detail.jsp?no=${ sessionScope.no }&fromUpdate=true';
</script>