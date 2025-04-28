site: http://localhost:8080

Go to: http://localhost:8080/swagger-ui.html to view the API documentation.

#máy móc :

- may moc dang hoat dong: /maymoc/active
- may moc hu hong: /maymoc/damaged
- danh sach may moc: /maymoc/list

#công trình

- cong trinh dang hoat dong: /congtrinh/active-count

#doi thau khoan : 
- so luong doi thau khoan: /doithau/count
    Query param: nguoiPhuTrach
    vi dụ: http://localhost:8080/doithau/count?nguoiPhuTrach=2
- danh sach doi thau khoan: /doithau/list-by-nhanvien
    Query param: nguoiPhuTrach
    vi dụ: http://localhost:8080/doithau/list-by-nhanvien?nguoiPhuTrach=2
#Task
- danh sach task theo trang thai: /task/count-by-status





