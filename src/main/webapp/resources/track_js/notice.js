function showNoticeList() {
    $.ajax({
        url: '/notice/list',
        type: 'GET',
        data: 'json',
        contentType: 'application/json; charset=utf-8',
        async: false,
        beforeSend: function (xhr) {
            xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
        },
        success: function (data) { //리스트 -> json
            var str = "<tr><th>제목</th><th>날짜</th><th>작성자</th></tr>" + printList(data);
            $('#noticeList').html(str);
        },
        error: function (error) {
            alert("ERROR발생: " + JSON.stringify(error));
        }
    })
};

// $('input[name=save]').click(function insertNotice() {
function insertNotice() {
    var data = {
        title: $('input[name=title]').val(),
        author: $('input[name=author]').val(),
        content: $('textarea').val()
    };
    console.log("data: ", data);

    $.ajax({
        url: '/notice/create',
        type: 'POST',
        contentType: 'application/json; charset=utf-8',
        dataType: 'json',
        data: JSON.stringify(data),
        async: false,
        beforeSend: function (xhr) {
            xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
        },
        success: function (data) {
            alert("공지가 등록되었습니다.");
        },
        error: function (error) {
            alert("ERROR발생: " + JSON.stringify(error));
            console.log(JSON.stringify(error));
        }
    });

};

function printList(jsonArray) {
    var str = "";

    for (var jsonObj in jsonArray) {
        var id = jsonArray[jsonObj].id;
        var title = jsonArray[jsonObj].title;
        var author = jsonArray[jsonObj].author;
        var date = jsonArray[jsonObj].date;

        console.log("id: " + id);
        str += '<tr><td>' + '<a href="/notice/details/' + id + '">' + title + '</a></td><td>' + date + '</td><td>' + author + '</td></tr>';

    }
    console.log("jsonArray: ", jsonArray);
    return str;
};

function updateNotice(noticeId) {
    alert("글수정을 눌렀습니다.");

    var data = {
        title: $('#selectedTitle').val(),
        author: $('#selectedAuthor').html(),
        content: $('#selectedContent').html()
    };

    console.log(noticeId);
    console.log("update함수 data: ", data);

    $.ajax({
        url: '/notice/update/' + noticeId,
        type: 'POST',
        data: JSON.stringify(data),
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        async: false,
        beforeSend: function (xhr) {
            xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
        },
        success: function (data) {
            alert("공지가 수정되었습니다.");
        },
        error: function (request, status, error) {
            alert("Error! 콘솔로그를 확인하세요");
            console.log("code:" + request.status + "\n\n" + "message:" + request.responseText + "\n\n" + "error:" + error);
        }
    })
};

function deleteNotice(noticeId) {
    alert("글삭제를 눌렀습니다.");
    var data = {
        title: $('#selectedTitle').val(),
        author: $('#selectedAuthor').val(),
        content: $('#selectedContent').val()
    };

    $.ajax({
        url: '/notice/delete/' + noticeId,
        type: 'POST',
        data: JSON.stringify(data),
        dataType: 'json',
        contentType: 'application/json; charset=utf-8',
        async: false,
        beforeSend: function (xhr) {
            xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");
        },
        success: function (data) {
            alert("공지가 삭제되었습니다.");
        },
        error: function (request, status, error) {
            alert("Error! 콘솔로그를 확인하세요");
            console.log("code:" + request.status + "\n\n" + "message:" + request.responseText + "\n\n" + "error:" + error);
        }
    })
};