1. QuizApplication.java 실행  
2. 웹브라우저에서 "http://localhost"  

```html
<!DOCTYPE html>
<html xmlns:th="http://www.thymeleaf.org"
      xmlns:layout="http://www.ultraq.net.nz/thymeleaf/layout"
      layout:decorate="~{layout/layout}">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<th:block layout:fragment="content">
예담퀴즈
</th:block>
</body>
</html>
```

3. 
