# movementsCreditTc
- Primero se debe ejecutar el servidor Eureka que se encuentra en el repositorio https://github.com/ajulcala/eurekaTc
- Segundo se debe ejecutar el servidor Config Server que se encuentra en el repositorio https://github.com/ajulcala/configServerTc
- Tercero registrar CUSTOMER https://github.com/ajulcala/customerTc

PAGOS

CREDIT PERSONAL 

para ver los pagos realizado a su cuenta de credito
http://localhost:8094/api/pay/checkbalance/personal a traves de un POST
Estructura:

{
    "number": "125-635-888-1",
    "password": "1234"
}

CREDIT EMPRESARIAL

para ver los pagos realizado a su cuenta de credito
http://localhost:8094/api/pay/checkbalance/business a traves de un POST

Estructura:

{
    "number": "125-635-888-1",
    "password": "1234"
}

PARA REALIZAR LOS PAGOS A LA TARJETA DE CREDITO PERSONAL:

http://localhost:8094/api/pay/creditpersonal/setcredit

Estructura:

{    
    "description": "primera cuota",
    "condition": 1,
    "amount": 1000.00,
    "card": {
        "number": "333-635-565-01",
        "password": "1234"
    }
}

PARA REALIZAR LOS PAGOS A LA TARJETA DE CREDITO EMPRESARIAL:

http://localhost:8094/api/pay/creditbusiness/setcredit

Estructura:

{    
    "description": "primera cuota",
    "condition": 1,
    "amount": 1000.00,
    "card": {
        "number": "333-635-565-01",
        "password": "1234"
    }
}

PARA VER LOS SALDOS DE LAS TARJETAS  

http://localhost:8094/api/pay/checkbalance/personal  a traves de POST
http://localhost:8094/api/pay/checkbalance/business a traves de POST

{
   "number": "333-635-565-01",
   "password": "1234"
}

RETIROS

CREDIT PERSONAL 

para ver los retiros realizado a su cuenta de credito
http://localhost:8094/api/consume/checkbalance/personal a traves de un POST
Estructura:

{
    "number": "125-635-888-1",
    "password": "1234"
}

CREDIT EMPRESARIAL

para ver los retiros realizado a su cuenta de credito
http://localhost:8094/api/consume/checkbalance/business a traves de un POST

Estructura:

{
    "number": "125-635-888-1",
    "password": "1234"
}

PARA REALIZAR LOS RETIROS A LA TARJETA DE CREDITO PERSONAL:

http://localhost:8094/api/consume/creditpersonal/setcredit

Estructura:

{    
    "description": "compra calzado",
    "condition": 1,
    "amount": 1000.00,
    "card": {
        "number": "333-635-565-01",
        "password": "1234"
    }
}

PARA REALIZAR LOS RETIROS A LA TARJETA DE CREDITO EMPRESARIAL:

http://localhost:8094/api/consume/creditbusiness/setcredit

Estructura:

{    
    "description": "compra calzado",
    "condition": 1,
    "amount": 1000.00,
    "card": {
        "number": "333-635-565-01",
        "password": "1234"
    }
}

PARA VER LOS SALDOS DE LAS TARJETAS  

http://localhost:8094/api/consume/checkbalance/personal  a traves de POST
http://localhost:8094/api/consume/checkbalance/business a traves de POST

{
   "number": "333-635-565-01",
   "password": "1234"
}
