<%--
  Created by IntelliJ IDEA.
  User: semanticbits
  Date: 12/3/18
  Time: 4:41 PM
  To change this template use File | Settings | File Templates.
--%>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<div class="container">

    <form action="/registration" method="post">
        <fieldset>

            <legend><h2><b>Bank Customer Registration Form</b></h2></legend><br>


            <div class="form-group">
                <label class=" control-label">Bank Name</label>
                <div class=" inputGroupContainer">
                    <div class="input-group">
                        <input  name="bank_name" class="form-control"  type="text">
                    </div>
                </div>
            </div>


            <div class="form-group">
                <label class=" control-label" >IFSC Code</label>
                <div class=" inputGroupContainer">
                    <div class="input-group">
                        <input name="ifsc_code"  class="form-control"  type="text">
                    </div>
                </div>
            </div>


            <div class="form-group">
                <label class=" control-label">Customer Name</label>
                <div class=" inputGroupContainer">
                    <div class="input-group">
                        <input  name="customer_name"  class="form-control"  type="text">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class=" control-label">Customer Id</label>
                <div class=" inputGroupContainer">
                    <div class="input-group">
                        <input  name="user_id"  class="form-control"  type="text">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class=" control-label" >Age</label>
                <div class=" inputGroupContainer">
                    <div class="input-group">
                        <input name="age" class="form-control"  type="text">
                    </div>
                </div>
            </div>


            <div class="form-group">
                <label class=" control-label" >Account Number</label>
                <div class=" inputGroupContainer">
                    <div class="input-group">
                        <input name="account_number" class="form-control" type="text">
                    </div>
                </div>
            </div>

            <div class="form-group">
                <label class=" control-label">Phone Number</label>
                <div class=" inputGroupContainer">
                    <div class="input-group">
                        <input name="phone_number" class="form-control"  type="text">
                    </div>
                </div>
            </div>



            <div class="form-group">
                <label class=" control-label">City Name</label>
                <div class=" inputGroupContainer">
                    <div class="input-group">
                        <input name="city_name" class="form-control" type="text">
                    </div>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label"></label>
                <div class=""><br>
                    <button type="submit"  >SUBMIT </button>
                </div>
            </div>

        </fieldset>
    </form>
</div>
</div>
</html>
