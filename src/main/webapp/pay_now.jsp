<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <!-- JQuery -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.4/jquery.min.js"></script>
    <!-- fonts -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">

    <title>Pay Now</title>
    <style type="text/css">
      .pay:hover{
  cursor: pointer;
  background-color: #ccc;
}
    </style>
  </head>
  <body >
    <div class="container col-lg-5 bg-light" >
      <h1>Payment</h1>
      <hr>
      <div>
        <table class="table table-borderless">
        <tr>
      <td><h2>Barbie 2023 <span>(U/A)</span></h2> <p class="text-muted">BLW Cinema Club</p></td>
      <td> <p class="text-end">Ticket <span>2</span></p>
        <p class="text-end">Ticket id: <span>CHE345</span></p></div></td></tr></table>
      
      <div>
        
      </div>


      <table class="table table-borderless">
          <tr>
            <th>Date</th>
            <th>Time</th>
            <th>Seat(s)</th>
          </tr>
          <tr>
            <td class="text-muted">03 August, 2023</td>
            <td class="text-muted">4:40pm</td>
            <td class="text-muted">A12, A13</td>
          </tr>
      </table>
      <hr>
      <table class="table table-borderless">
        <tr>
          <th>Subtotal</th>
          <td class="text-end text-muted"> <span>&#8377</span> 500</td>
        </tr>
        <th>Internet handling charge</th>
          <td class="text-end text-muted"> <span>&#8377</span> 10</td>
        </tr>
        <tr style="border-top: 1px solid grey;">
        <th>Total</th>
          <td class="text-end text-muted"> <span>&#8377</span> 510</td>
        </tr>
      </table>

      <div>
        <h3>Choose payment method</h1>
          <hr>
          <table class="table">
        <tr class="pay">
          <th><i class="fa fa-google"></i>&nbsp&nbspGoogle Pay</th>
          <td class="text-end text-muted">&#62</td>
        </tr>
        <tr class="pay">
          <th> <i class="fa fa-amazon"></i>&nbsp&nbspAmazon Pay</th>
          <td class="text-end text-muted">&#62</td>
        </tr>
        <tr class="pay">
          <th><i class="  fa fa-google-wallet"></i>&nbsp&nbspUPI</th>
          <td class="text-end text-muted">&#62</td>
        </tr>
        <tr class="pay">
          <th><i class=" fa fa-credit-card"></i>&nbsp&nbspDebit/Credit Card</th>
          <td class="text-end text-muted">&#62</td>
        </tr>
        <tr class="pay">
          <th>More payment option</th>
          <td class="text-end text-muted">&#62</td>
        </tr>
      </table>
      </div>

      <div>
        <p class="text-muted">&#9432; By proceeding, I express my consent to complete this transaction.</p>
      </div>
      <div>
        <input type="button" name="goBack" value="Go Back"class="btn btn-primary btn-lg btn-block">
      </div>
    </div>

    <!-- JQuery -->
    <script type="text/javascript">
      $(window).ready(function(){
        $(".pay").click(function(){
           window.location = "ticket.html";
        })
      });
    </script>
    <!-- Resource links -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    
  </body>
</html>