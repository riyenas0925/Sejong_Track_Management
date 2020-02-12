<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!-- Modal -->
<div class="modal fade" id="list" tabindex="-1" role="dialog" aria-labelledby="listLabel" aria-hidden="true">
    <div class="modal-dialog modal-dialog-centered" role="document">
        <div class="modal-content">
            <div class="modal-header">
                <h5 class="modal-title" id="listLabel">강의시간표 목록</h5>
                <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                    <span aria-hidden="true">&times;</span>
                </button>
            </div>
            <div class="modal-body">
                <div class="table-responsive">
                    <div>
                        <table class="table align-items-center">
                            <thead class="thead-light">
                            <tr>
                                <th scope="col" class="text-center">
                                    파일번호
                                </th>
                                <th scope="col">
                                    파일 명
                                </th>
                                <th></th>
                            </tr>
                            </thead>
                            <tbody class="list" id="listModalTable">

                            </tbody>
                        </table>
                    </div>
                </div>

            </div>
            <div class="modal-footer">
                <button type="button" class="btn btn-primary">Close</button>
            </div>
        </div>
    </div>
</div>