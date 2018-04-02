function validate()
{
    var cardDD = document.getElementById("cardType");
    var pCard = cardDD.options[cardDD.selectedIndex].text;
    var rates = document.getElementsByName("card");
    var rate_value="";
    for(var i = 0; i < rates.length; i++)
    {
        if(rates[i].checked)
        {
            rate_value = rates[i].value;
        }
    }    
    var date = document.getElementById("date").value;
    var year = date[2];
    var month = date[1];
    var day = date[0];
    var city = document.myForm.city;
    var country = document.myForm.country;
    var addrType = document.myForm. addrT;
    var street = document.myForm.street;
    var locality = document.myForm.locality;
    var zip = document.myForm.zip;
    var fName = document.myForm.fname;
    var lName = document.myForm.lname;
    var mob = document.myForm.mobile;
    if(fName.value.length == 0)
    {
        alert("Name field cannot be empty")
        return false;
    }
    if(lName.value.length == 0)
    {
        alert("Name field cannot be empty")
        return false;
    }
    if(year.value<2018)
    {
        alert("Expiry date is wrong")
        return false;
    }
    if(city.value.length == 0)
    {
        alert("City field cannot be empty")
        return false;
    }
    if(country.value.length == 0)
    {
        alert("Country field cannot be empty")
        return false;
    }
    if(street.value.length == 0)
    {
        alert("Street field cannot be empty")
        return false;
    }
    if(locality.value.length == 0)
    {
        alert("Locality field cannot be empty")
        return false;
    }
    if(addrType.value.length == 0)
    {
        alert("Address Type field cannot be empty")
        return false;
    }
    if(zip.value.length == 0)
    {
        alert("Zip Code field cannot be empty")
        return false;
    }
    if(mob.value.length != 10)
    {
        alert("Mobile Number should have exactly 10 characters!!");
        return false;
    }
        alert("Successfully Registered");
        document.body.innerHTML = "<html><head><title>Details Displayed.</title></head><body><b><pre id=\"out\" > </pre></b></body></html>"
        if(rate_value.valueOf()==="pp")
        {    
            msg = "TYPE = PayPal\nFirst Name : "+fName.value+"\nLast Name : "+lName.value+"\nCard Chosen : "+"\nMobile : "+mob.value+"\n"+"Street : "+street.value+"\nLoaclity : "+locality.value+"\nZip Code : "+zip.value+"\n";
        }
        else
        {
            msg = "TYPE = Credit Card\nFirst Name : "+fName.value+"\nLast Name : "+lName.value+"\nCard Chosen : "+"\nMobile : "+mob.value+"\n"+"Street : "+street.value+"\nLoaclity : "+locality.value+"\nZip Code : "+zip.value+"\n";
        }
        document.getElementById("out").innerHTML = msg;
        return true;
}