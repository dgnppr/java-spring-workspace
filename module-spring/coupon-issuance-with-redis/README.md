# 선착순 쿠폰 발급 with Redis Sorted Set

![](https://velog.velcdn.com/images/dragonappear/post/8b89f0f7-0cf0-4a4c-975b-09d83fab1070/image.png)

- Key = 이벤트명
- Value = 사용자 ID
- Score = 유닉스타임( 요청 순서대로 정렬하기 위해서 유닉스 타임 사용)

![](https://velog.velcdn.com/images/dragonappear/post/876db086-d105-4957-88cb-4d5b079ce3d4/image.png)

# 테스트

![](https://velog.velcdn.com/images/dragonappear/post/89b1fd7b-345a-4c94-95cc-e6f76765b8d6/image.png)

![](https://velog.velcdn.com/images/dragonappear/post/ec076340-60ce-4d43-bee9-799761b98b33/image.png)

![](https://velog.velcdn.com/images/dragonappear/post/a958600a-69bb-43a9-9d06-115aafc3fa25/image.png)

시간 순으로 처리