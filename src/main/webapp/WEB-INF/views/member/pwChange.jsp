<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Modal -->
<div class="modal fade" id="passwordChange" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel"
     aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="exampleModalLabel">비밀번호 변경</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <form id="modifyForm">
            <div class="modal-body">
                    <div class="row">
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label class="form-control-label" for="originalPassword">기존 비밀번호</label>
                                <input type="password" class="form-control" name="originalPassword" id="originalPassword" required
                                       placeholder="original password">
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label class="form-control-label" for="newPw">새 비밀번호</label>
                                <input type="password" class="form-control" name="newPw" id="newPw" required
                                       placeholder="new password">
                            </div>
                        </div>
                        <div class="col-lg-12">
                            <div class="form-group">
                                <label class="form-control-label" for="newPwRe">재입력</label>
                                <input type="password" class="form-control" name="newPwRe" id="newPwRe" required
                                       placeholder="retype new password">
                            </div>
                            <div class="col-xs-8"><span id="pwCheckRes"></span></div>
                        </div>
                    </div>
            </div>
            <div class="modal-footer">
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
                <input type="hidden" name="id" value="<sec:authentication property='principal.id'/>"/>
                <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                <input type="button" name="pwModifyBtn" class="btn btn-primary" value="modify"/>
            </div>
            </form>
        </div>
    </div>
</div>