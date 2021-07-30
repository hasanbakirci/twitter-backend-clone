## Spring boot öğrenirken yapmış olduğum basit bir twitter-clone projesi

User Controller:
User ekleme, User listeleme , User isme göre arama

    http://localhost:8080/api/users/save
	http://localhost:8080/api/users/findall
	http://localhost:8080/api/users/getByusername?username=isim

____

Twit Controller:
Twit ekleme, Twit listeleme, İsme göre twit arama, Timeline listeleme

    http://localhost:8080/api/twits/save
	http://localhost:8080/api/twits/findall
	http://localhost:8080/api/twits/findByUsernameTwit?username=isim
    http://localhost:8080/api/twits/findByTimelineTwit?username=isim
___

Follow Controller:
Takipçi ekleme, Takip edilenleri listeleme, Takipçileri listeleme

    http://localhost:8080/api/follow/save
    http://localhost:8080/api/follow/findall
	http://localhost:8080/api/follow/findByUserFollowing?username=isim
	http://localhost:8080/api/follow/findByUserFollower?username=isim
___

gibi api'ler çalışmaktadır.
