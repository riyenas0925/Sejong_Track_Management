var ruleService = (function() {
    
    function list(univId, callback, error) {
        $.getJSON("rule/list/" + univId,
            function(data) {
                if(callback){
                    callback(data);
                }
            }).fail(function(xhr, status, err) {
            if (error) {
                error(err);
            }
        });
    }
    
    function create(modalAttr, callback, error) {

        var track = {
            trackId : modalAttr.trackId,
        };

        var degree = {
            degreeId : modalAttr.degreeId,
        };

        var ruleJson = JSON.stringify({
            basicCredit : modalAttr.basicCredit,
            appliedCredit : modalAttr.appliedCredit,
            industryCredit : modalAttr.industryCredit,
            track : track,
            degree : degree
        });

        $.ajax({
            type: "post",
            url: "rule/create",
            headers: {
                "Content-Type": "application/json",
                "X-HTTP-Method-Override": "POST"
            },
            dataType: "text",
            data: ruleJson,
            success : function(result, status, xhr) {
                if (callback) {
                    callback(result);
                }
            },
            error : function(xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        });
    }

    function update(modalAttr, callback, error) {

        var track = {
            trackId : modalAttr.trackId,
        };

        var degree = {
            degreeId : modalAttr.degreeId,
        };

        var ruleJson = JSON.stringify({
            ruleId : modalAttr.rule,
            basicCredit : modalAttr.basicCredit,
            appliedCredit : modalAttr.appliedCredit,
            industryCredit : modalAttr.industryCredit,
            track : track,
            degree : degree
        });

        $.ajax({
            type: "post",
            url: "rule/create",
            headers: {
                "Content-Type": "application/json",
                "X-HTTP-Method-Override": "POST"
            },
            dataType: "text",
            data: ruleJson,
            success : function(result, status, xhr) {
                if (callback) {
                    callback(result);
                }
            },
            error : function(xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        });
    }
    
    function remove(ruleId, callback, error) {
        $.ajax({
            type: "delete",
            url: "rule/delete/" + ruleId,
            headers: {
                "Content-Type": "application/json",
                "X-HTTP-Method-Override": "DELETE"
            },
            dataType: "text",
            success : function(result, status, xhr) {
                if (callback) {
                    callback(result);
                }
            },
            error : function(xhr, status, err) {
                if (error) {
                    error(err);
                }
            }
        });
    }
    
    function attribute(rule) {
        var td = rule.parent().parent().children();

        var ruleAttr = {
            ruleId : td.eq(0).text(),
            univTitle : td.eq(1).text(),
            trackTitle : td.eq(2).text(),
            degreeTitle : td.eq(3).text(),
            basicCredit : td.eq(4).text(),
            appliedCredit : td.eq(5).text(),
            industryCredit : td.eq(6).text(),
            trackId : td.eq(7).text(),
            degreeId : td.eq(8).text(),
        };

        return ruleAttr;
    }

    function modalAttr() {

        var modal = {
            ruleId: $('.modal-header').attr('id'),
            basicCredit: $('#basic_credit').val(),
            appliedCredit: $('#applied_credit').val(),
            industryCredit: $('#industry_credit').val(),
            trackId: $('#select_track').val(),
            degreeId: $('#select_degree').val(),
        }

        console.log(modal);

        return modal;
    };

    function creditDisable(status, basic, applied, industry){
        if (arguments.length == 4){
            $("#basic_credit").val(basic).attr("disabled",status);
            $("#applied_credit").val(applied).attr("disabled",status);
            $("#industry_credit").val(industry).attr("disabled",status);
        } else if (arguments.length == 1){
            $("#basic_credit").attr("disabled",status);
            $("#applied_credit").attr("disabled",status);
            $("#industry_credit").attr("disabled",status);
        }
    }

    return {
        list : list,
        create : create,
        remove : remove,
        update : update,
        attribute : attribute,
        creditDisable : creditDisable,
        modalAttr : modalAttr
    }
})();