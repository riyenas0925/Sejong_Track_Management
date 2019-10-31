var selectService = (function() {

    function univ() {
        $.getJSON("select/univ", function (data) {
            var str = "<option value='-1'>- 대학 선택 -</option>";

            $(data).each(
                function () {
                    str += "<option value='" + this.univId + "'>" + this.univTitle + "(" + this.univNo + ")" + "</option>"
                });

            $("#select_univ").html(str);
        });
    }

    function track(selectUniv) {
        $.getJSON("select/track/" + selectUniv, function (data) {
            var str = "<option value='-1'>- 트랙 선택 -</option>";

            console.log(selectUniv);

            $(data).each(
                function () {
                    str += "<option value='" + this.trackId + "'>" + this.trackTitle + "(" + this.trackNo + ")" + "</option>"
                });

            $("#select_track").html(str);
        });
    }

    function degree() {
        $.getJSON("select/degree", function (data) {
            var str = "<option value='-1'>- 학위 선택 -</option>";

            $(data).each(
                function () {
                    str += "<option value='" + this.degreeId + "'>" + this.degreeTitle + "</option>"
                });

            $("#select_degree").html(str);
        });
    }

    return{
        univ : univ,
        track : track,
        degree : degree
    }
})();