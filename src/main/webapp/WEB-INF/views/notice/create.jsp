<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Modal -->
<div class="modal fade" id="noticeCreate" tabindex="-1" role="dialog" aria-labelledby="create" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="create">글 쓰기</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form>
                <div class="modal-body">
                    <div class="form-group">
                    <label for="createTitle">제목</label>
                    <input class="form-control" type="text" name="title" id="createTitle" required/>
                </div>
                    <div class="form-group">
                        <label for="createAuthor">작성자</label>
                        <input class="form-control" type="text" name="author" value="관리자" id="createAuthor" required/>
                    </div>
                    <div class="form-group">
                        <label for="createText">본문</label>
                        <textarea class="form-control" id="createText" required></textarea>
                    </div>
                </div>
                <div class="modal-footer">
                    <button type="button" class="btn btn-secondary" data-dismiss="modal">취소</button>
                    <button type="button" name="save" class="btn btn-success" onclick="insertNotice()">글 쓰기</button>
                </div>
            </form>
        </div>
    </div>
</div>

<script type="text/javascript">
    function insertNotice() {
        var data = {
            title: $('input[name=title]').val(),
            author: $('input[name=author]').val(),
            content: $('textarea').val()
        };
        console.log("data: ", data);

        $.ajax({
            url: 'api/v1/admin/notice/create',
            type: 'POST',
            contentType: 'application/json; charset=utf-8',
            dataType: 'json',
            data: JSON.stringify(data),
            async: false,
            <%--beforeSend: function (xhr) {--%>
            <%--xhr.setRequestHeader("${_csrf.headerName}", "${_csrf.token}");--%>
            <%--},--%>
            success: function (data) {
                alert("공지가 등록되었습니다.");
                window.location.replace("${path}/notice");
            },
            error: function (error) {
                alert("ERROR발생: " + JSON.stringify(error));
                console.log(JSON.stringify(error));
            }
        });
    };
</script>
