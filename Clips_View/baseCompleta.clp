(defclass recomendacion (is-a USER)
	(slot nombre
		(type STRING)
	)
	(slot tipo
		(type STRING)
	)
	(slot precio
		(type INTEGER)
	)
	(slot tiempoAhorrado
		(type SYMBOL)
		(allowed-symbols bajo medio alto)
	)
)

(defclass sinVehiculo (is-a recomendacion)
	(slot ventaja
		(type STRING)
	)
	(slot desventaja
		(type STRING)
	)
)

(defclass vehiculo (is-a recomendacion)
	(slot cFuerza
		(type INTEGER)
	)
	(slot velocidadM
		(type INTEGER)
	)
	(slot capacidad
		(type INTEGER)
	)
)

(defclass persona (is-a USER)
	(slot nombre
		(type STRING)
	)
	(slot apellido
		(type STRING)
	)
	(slot fondos
		(type INTEGER)
	)
	(slot tipoR
		(type STRING)
	)
	(slot vrecomendado
		(type STRING)
	)
)

(deftemplate cuestionario
	(slot transportepop
		(type STRING)
		(default "otro") 
	)
	(slot viajes
		(type STRING)
		(default "no")
	)
	(slot compras
		(type STRING)
		(default "no")
	)
	(slot comprasacomp
		(type STRING)
		(default "no") 
	)
	(slot cargarcomp
		(type STRING)
		(default "no") 
	)
	(slot irtrabajo
		(type STRING)
		(default "no") 
	)
	(slot ruralurbano
		(type STRING)
		(default "rural") 
	)
	(slot trabajocerca
		(type STRING)
		(default "cerca") 
	)
	(slot facilidadtranspub
		(type STRING)
		(default "facil") 
	)
	(slot licencia
		(type STRING)
		(default "no") 
	)
	(slot rango
		(type STRING)
		(default "A") 
	)
)

(defmessage-handler persona resultado () 
	(printout t "La persona " ?self:nombre " " ?self:apellido " con presupuesto de " ?self:fondos ", se le recomienda trasnportarse con: " ?self:tipoR "; si es posible conseguir este transporte: " ?self:vrecomendado crlf)
)


(defglobal ?*pnada* = 0 )
(defglobal ?*pmoto* = 0 )
(defglobal ?*pcarro* = 0 )
(defglobal ?*opcion* = 0 )
(defglobal ?*usuario* = 0 )
(defglobal ?*pos* = 0)
(defglobal ?*nomop* = 0)
(defglobal ?*nombreusu* = 0)

;(make-instance Nada of sinVehiculo (nombre "Nada")(tipo "nada")(precio 0)(tiempoAhorrado bajo)(ventaja "gratis y una caminata no hace mal a nadie")(desventaja "lento"))
;(make-instance Bicicleta of sinVehiculo (nombre "Bicicleta")(tipo "nada")(precio 500)(tiempoAhorrado medio)(ventaja "costo bajo y no contamina")(desventaja "es para una sola persona"))

;(make-instance XTZ-125 of vehiculo (nombre "XTZ-125")(tipo "moto")(precio 1790)(tiempoAhorrado alto)(cFuerza 10)(velocidadM 90)(capacidad 2))
;(make-instance R3A of vehiculo (nombre "R3A")(tipo "moto")(precio 4790)(tiempoAhorrado alto)(cFuerza 42)(velocidadM 170)(capacidad 2))
;(make-instance FZ-25 of vehiculo (nombre "FZ-25")(tipo "moto")(precio 2490)(tiempoAhorrado alto)(cFuerza 25)(velocidadM 140)(capacidad 2))
;(make-instance XA-125 of vehiculo (nombre "XA-125")(tipo "moto")(precio 1490)(tiempoAhorrado alto)(cFuerza 8)(velocidadM 100)(capacidad 2))

;(make-instance SparkGT of vehiculo (nombre "SparkGT")(tipo "carro")(precio 13399)(tiempoAhorrado alto)(cFuerza 80)(velocidadM 156)(capacidad 5))
;(make-instance Tracker of vehiculo (nombre "Tracker")(tipo "carro")(precio 25499)(tiempoAhorrado alto)(cFuerza 138)(velocidadM 180)(capacidad 5))
;(make-instance D-Max-High-Power of vehiculo (nombre "D-Max-High-Power")(tipo "carro")(precio 27499)(tiempoAhorrado alto)(cFuerza 136)(velocidadM 170)(capacidad 5))
;(make-instance SailSedan of vehiculo (nombre "SailSedan")(tipo "carro")(precio 17499)(tiempoAhorrado alto)(cFuerza 109)(velocidadM 170)(capacidad 5))


;(make-instance Pablo of persona (nombre "Pablo") (apellido "Loja") (fondos 10000) (tipoR "") (vrecomendado ""))

(defrule puntosNada
	(cuestionario (viajes ?vi) (compras ?co) (irtrabajo ?it) (trabajocerca ?tc) (rango ?ra))
=>
	(bind ?*pnada* 0)
	(if (= (str-compare ?vi "no") 0)
	then
		(bind ?*pnada* (+ ?*pnada* 1))
	)
	(if (= (str-compare ?co "no") 0)
	then
		(bind ?*pnada* (+ ?*pnada* 1))
	)
	(if (= (str-compare ?it "no") 0)
	then
		(bind ?*pnada* (+ ?*pnada* 1))
	)
	(if (= (str-compare ?tc "lejos") 0)
	then
		(bind ?*pnada* (+ ?*pnada* 1))
	)
	(if (= (str-compare ?ra "C") 0)
	then
		(bind ?*pnada* (+ ?*pnada* 1))
	)
)

(defrule puntosMoto
	(cuestionario (viajes ?vi) (compras ?co) (irtrabajo ?it) (trabajocerca ?tc) (facilidadtranspub ?ftp) (licencia ?li) (rango ?ra))
=>
	(bind ?*pmoto* 0)
	(if (= (str-compare ?vi "solo") 0)
	then
		(bind ?*pmoto* (+ ?*pmoto* 1))
	)
	(if (= (str-compare ?co "si") 0)
	then
		(bind ?*pmoto* (+ ?*pmoto* 1))
	)
	(if (= (str-compare ?it "si") 0)
	then
		(bind ?*pmoto* (+ ?*pmoto* 1))
	)
	(if (= (str-compare ?tc "lejos") 0)
	then
		(bind ?*pmoto* (+ ?*pmoto* 1))
	)
	(if (= (str-compare ?ftp "dificil") 0)
	then
		(bind ?*pmoto* (+ ?*pmoto* 1))
	)
	(if (= (str-compare ?li "si") 0)
	then
		(bind ?*pmoto* (+ ?*pmoto* 1))
	)
	(if (= (str-compare ?ra "A") 0)
	then
		(bind ?*pmoto* (+ ?*pmoto* 1))
	else (if (= (str-compare ?ra "B") 0)
		then
			(bind ?*pmoto* (+ ?*pmoto* 1))
		)
	)
)

(defrule puntosCarro
	(cuestionario (viajes ?vi) (compras ?co) (cargarcomp ?cc) (irtrabajo ?it) (trabajocerca ?tc) (facilidadtranspub ?ftp) (licencia ?li) (rango ?ra))
=>
	(bind ?*pcarro* 0)
	(if (= (str-compare ?vi "si") 0)
	then
		(bind ?*pcarro* (+ ?*pcarro* 1))
	)
	(if (= (str-compare ?co "si") 0)
	then
		(bind ?*pcarro* (+ ?*pcarro* 1))
	)
	(if (= (str-compare ?cc "si") 0)
	then
		(bind ?*pcarro* (+ ?*pcarro* 1))
	)
	(if (= (str-compare ?it "si") 0)
	then
		(bind ?*pcarro* (+ ?*pcarro* 1))
	)
	(if (= (str-compare ?tc "lejos") 0)
	then
		(bind ?*pcarro* (+ ?*pcarro* 1))
	)
	(if (= (str-compare ?ftp "dificil") 0)
	then
		(bind ?*pcarro* (+ ?*pcarro* 1))
	)
	(if (= (str-compare ?li "si") 0)
	then
		(bind ?*pcarro* (+ ?*pcarro* 1))
	)
	(if (= (str-compare ?ra "B") 0)
	then
		(bind ?*pcarro* (+ ?*pcarro* 1))
	else (if (= (str-compare ?ra "C") 0)
		then
			(bind ?*pcarro* (+ ?*pcarro* 1))
		)
	)
)

(deffunction opcionNada (?vi ?co ?it ?tc ?ftp)
	(bind ?array (create$ 0 0))
	(if (= (str-compare ?vi "no") 0)
	then
		(bind ?array (create$ (+ (nth$ 1 ?array) 1) (nth$ 2 ?array)))
	else
		(bind ?array (create$ (nth$ 1 ?array) (+ (nth$ 2 ?array) 1)))
	)
	(if (= (str-compare ?co "no") 0)
	then
		(bind ?array (create$ (+ (nth$ 1 ?array) 1) (nth$ 2 ?array)))
	)
	(if (= (str-compare ?it "no") 0)
	then
		(bind ?array (create$ (nth$ 1 ?array) (+ (nth$ 2 ?array) 1)))
	)
	(if (= (str-compare ?tc "no") 0)
	then
		(bind ?array (create$ (nth$ 1 ?array) (+ (nth$ 2 ?array) 1)))
	)
	(if (= (str-compare ?ftp "facil") 0)
	then
		(bind ?array (create$ (+ (nth$ 1 ?array) 1) (nth$ 2 ?array)))
	else
		(bind ?array (create$ (nth$ 1 ?array) (+ (nth$ 2 ?array) 1)))
	)

	(if (> (nth$ 1 ?array) (nth$ 2 ?array))
	then
		(modify-instance ?*usuario* (tipoR ?*opcion*) (vrecomendado "Nada"))
		(bind ?*nomop* "Nada")
	else
		(modify-instance ?*usuario* (tipoR ?*opcion*) (vrecomendado "Bicicleta"))
		(bind ?*nomop* "Bicicleta")
	)
)

(deffunction opcionMoto (?vi ?cacomp ?it ?ru ?tc ?ftp ?ra)
	(bind ?todas (create$ "XTZ-125" "R3A" "FZ-25" "XA-125"))
	(bind ?array (create$ 0 0 0 0))
	(if (= (str-compare ?vi "solo") 0)
	then
		(bind ?array (create$ (nth$ 1 ?array) (nth$ 2 ?array) (+ (nth$ 3 ?array) 1) (nth$ 4 ?array)))
	)
	(if (= (str-compare ?cacomp "no") 0)
	then
		(bind ?array (create$ (nth$ 1 ?array) (+ (nth$ 2 ?array) 1) (+ (nth$ 3 ?array) 1) (nth$ 4 ?array)))
	)
	(if (= (str-compare ?it "no") 0)
	then
		(bind ?array (create$ (nth$ 1 ?array) (nth$ 2 ?array) (nth$ 3 ?array) (+ (nth$ 4 ?array) 1)))
	else
		(bind ?array (create$ (nth$ 1 ?array) (+ (nth$ 2 ?array) 1) (+ (nth$ 3 ?array) 1) (nth$ 4 ?array)))
	)
	(if (= (str-compare ?ru "rural") 0)
	then
		(bind ?array (create$ (+ (nth$ 1 ?array) 1) (nth$ 2 ?array) (nth$ 3 ?array) (nth$ 4 ?array) ))
	else
		(bind ?array (create$ (nth$ 1 ?array) (+ (nth$ 2 ?array) 1) (+ (nth$ 3 ?array) 1) (+ (nth$ 4 ?array) 1)))
	)
	(if (= (str-compare ?tc "cerca") 0)
	then
		(bind ?array (create$ (nth$ 1 ?array) (nth$ 2 ?array) (nth$ 3 ?array) (+ (nth$ 4 ?array) 1)))
	else
		(bind ?array (create$ (nth$ 1 ?array) (+ (nth$ 2 ?array) 1) (+ (nth$ 3 ?array) 1) (nth$ 4 ?array)))
	)
	(if (= (str-compare ?ftp "dificil") 0)
	then
		(bind ?array (create$ (+ (nth$ 1 ?array) 1) (nth$ 2 ?array) (nth$ 3 ?array) (nth$ 4 ?array) ))
	)
	(if (= (str-compare ?ra "A") 0)
	then
		(bind ?array (create$ (+ (nth$ 1 ?array) 1) (nth$ 2 ?array) (+ (nth$ 3 ?array) 1) (+ (nth$ 4 ?array) 1) ))
	else 
		(bind ?array (create$ (nth$ 1 ?array) (+ (nth$ 2 ?array) 1) (nth$ 3 ?array) (nth$ 4 ?array) ))
	)

	(bind ?*pos* 1)
	(loop-for-count (?i 2 4)
		(bind ?pa (- ?i 1))
		(if (> (nth$ ?i ?array) (nth$ ?pa ?array))
		then
			(bind ?*pos* ?i)
		)
	)
	
	(modify-instance ?*usuario* (tipoR ?*opcion*) (vrecomendado (nth$ ?*pos* ?todas)))
	(bind ?*nomop* (nth$ ?*pos* ?todas))	
)

(deffunction opcionCarro (?vi ?co ?cacomp ?cc ?it ?ru ?tc ?ftp ?ra)
	(bind ?todas (create$ "SparkGT" "Tracker" "D-Max-High-Power" "SailSedan"))
	(bind ?array (create$ 0 0 0 0))

	
	(if (= (str-compare ?vi "si") 0)
	then
		(bind ?array (create$ (nth$ 1 ?array) (+ (nth$ 2 ?array) 1) (nth$ 3 ?array) (+ (nth$ 4 ?array) 1)))
	else
		(bind ?array (create$ (+ (nth$ 1 ?array) 1) (nth$ 2 ?array) (nth$ 3 ?array) (nth$ 4 ?array)))
	)
	(if (= (str-compare ?co "si") 0)
	then
		(bind ?array (create$ (+ (nth$ 1 ?array) 1) (+ (nth$ 2 ?array) 1) (+ (nth$ 3 ?array) 1) (nth$ 4 ?array)))
	)
	(if (= (str-compare ?cacomp "si") 0)
	then
		(bind ?array (create$ (nth$ 1 ?array) (+ (nth$ 2 ?array) 1) (+ (nth$ 3 ?array) 1) (+ (nth$ 4 ?array) 1)))
	)
	(if (= (str-compare ?cc "si") 0)
	then
		(bind ?array (create$ (+ (nth$ 1 ?array) 1) (+ (nth$ 2 ?array) 1) (+ (nth$ 3 ?array) 1) (nth$ 4 ?array)))
	)
	(if (= (str-compare ?it "si") 0)
	then
		(bind ?array (create$ (+ (nth$ 1 ?array) 1) (nth$ 2 ?array) (nth$ 3 ?array) (+ (nth$ 4 ?array) 1)))
	)
	(if (= (str-compare ?ru "rural") 0)
	then
		(bind ?array (create$ (nth$ 1 ?array) (+ (nth$ 2 ?array) 1) (+ (nth$ 3 ?array) 1) (nth$ 4 ?array)))
	else
		(bind ?array (create$ (+ (nth$ 1 ?array) 1) (nth$ 2 ?array) (nth$ 3 ?array) (+ (nth$ 4 ?array) 1)))
	)
	(if (= (str-compare ?tc "cerca") 0)
	then
		(bind ?array (create$ (+ (nth$ 1 ?array) 1) (nth$ 2 ?array) (nth$ 3 ?array) (nth$ 4 ?array)))
	else
		(bind ?array (create$ (nth$ 1 ?array) (+ (nth$ 2 ?array) 1) (+ (nth$ 3 ?array) 1) (+ (nth$ 4 ?array) 1)))
	)
	(if (= (str-compare ?ftp "dificil") 0)
	then
		(bind ?array (create$ (nth$ 1 ?array) (nth$ 2 ?array) (+ (nth$ 3 ?array) 1) (nth$ 4 ?array)))
	)
	(if (= (str-compare ?ra "B") 0)
	then
		(bind ?array (create$ (+ (nth$ 1 ?array) 1) (nth$ 2 ?array) (nth$ 3 ?array) (+ (nth$ 4 ?array) 1)))
	else 
		(bind ?array (create$ (nth$ 1 ?array) (+ (nth$ 2 ?array) 1) (+ (nth$ 3 ?array) 1) (nth$ 4 ?array)))
	)
	(bind ?*pos* 1)
	(loop-for-count (?i 2 4)
		(bind ?pa (- ?i 1))
		(if (> (nth$ ?i ?array) (nth$ ?pa ?array))
		then
			(bind ?*pos* ?i)
		)
	)
	

	(modify-instance ?*usuario* (tipoR ?*opcion*) (vrecomendado (nth$ ?*pos* ?todas)))
	(bind ?*nomop* (nth$ ?*pos* ?todas))
)

(defrule resultado
	(cuestionario (transportepop ?tpop) (viajes ?vi) (compras ?co) (comprasacomp ?cacomp) (cargarcomp ?cc) (irtrabajo ?it) (ruralurbano ?ru) (trabajocerca ?tc) (facilidadtranspub ?ftp) (licencia ?li) (rango ?ra))
=>
	(bind ?resul 0)
	(if (= (str-compare ?tpop "otro") 0)
	then
		(bind ?resul (+ ?resul 3))
	else (if (= (str-compare ?tpop "publico") 0)
		then
			(bind ?resul (+ ?resul 6))
		else
			(bind ?resul (+ ?resul 9))
		)
	)
	(if (= (str-compare ?vi "no") 0)
	then
		(bind ?resul (+ ?resul 2))
	else (if (= (str-compare ?vi "solo") 0)
		then
			(bind ?resul (+ ?resul 5))
		else
			(bind ?resul (+ ?resul 8))
		)
	)
	(if (= (str-compare ?co "no") 0)
	then
		(bind ?resul (+ ?resul 2))
	else
		(bind ?resul (+ ?resul 5))
	)
	(if (= (str-compare ?cacomp "no") 0)
	then
		(bind ?resul (+ ?resul 2))
	else
		(bind ?resul (+ ?resul 5))
	)
	(if (= (str-compare ?cc "no") 0)
	then
		(bind ?resul (+ ?resul 5))
	else
		(bind ?resul (+ ?resul 8))
	)
	(if (= (str-compare ?it "no") 0)
	then
		(bind ?resul (+ ?resul 3))
	else
		(bind ?resul (+ ?resul 6))
	)
	(if (= (str-compare ?ru "rural") 0)
	then
		(bind ?resul (+ ?resul 3))
	else
		(bind ?resul (+ ?resul 3))
	)
	(if (= (str-compare ?tc "cerca") 0)
	then
		(bind ?resul (+ ?resul 2))
	else
		(bind ?resul (+ ?resul 7))
	)
	(if (= (str-compare ?ftp "facil") 0)
	then
		(bind ?resul (+ ?resul 4))
	else
		(bind ?resul (+ ?resul 7))
	)
	(if (= (str-compare ?li "no") 0)
	then
		(bind ?resul (+ ?resul 2))
	else (if (= (str-compare ?li "proceso") 0)
		then
			(bind ?resul (+ ?resul 4))
		else
			(bind ?resul (+ ?resul 6))
		)
	)
	(if (= (str-compare ?ra "A") 0)
	then
		(bind ?resul (+ ?resul 1))
	else (if (= (str-compare ?ra "B") 0)
		then
			(bind ?resul (+ ?resul 3))
		else
			(bind ?resul (+ ?resul 3))
		)
	)

	(if (and (> ?resul 28) (< ?resul 39))
	then
		(bind ?*opcion* "nada")
		(opcionNada ?vi ?co ?it ?tc ?ftp)
	)
	(if (and (> ?resul 38) (<= ?resul 45))
	then
		(if (> ?*pnada* ?*pmoto*)
		then
			(bind ?*opcion* "nada")
			(opcionNada ?vi ?co ?it ?tc ?ftp)
		else
			(bind ?*opcion* "moto")
			(opcionMoto ?vi ?cacomp ?it ?ru ?tc ?ftp ?ra)
		)
	)
	(if (and (> ?resul 44) (< ?resul 52))
	then
		(bind ?*opcion* "moto")
		(opcionMoto ?vi ?cacomp ?it ?ru ?tc ?ftp ?ra)
	)
	(if (and (> ?resul 51) (< ?resul 58))
	then
		(if (> ?*pmoto* ?*pcarro*)
		then
			(bind ?*opcion* "moto")
			(opcionMoto ?vi ?cacomp ?it ?ru ?tc ?ftp ?ra)
		else
			(bind ?*opcion* "carro")
			(opcionCarro ?vi ?co ?cacomp ?cc ?it ?ru ?tc ?ftp ?ra)
		)
	)
	(if (and (> ?resul 57) (< ?resul 68))
	then
		(bind ?*opcion* "carro")
		(opcionCarro ?vi ?co ?cacomp ?cc ?it ?ru ?tc ?ftp ?ra)
	)
)

(defrule mensaje
    (object (is-a persona) (nombre ?n)(apellido ?a)(fondos ?f)(tipoR ?tr)(vrecomendado ?vr))
    (test (eq ?*nombreusu* ?n))
=>
	(if (eq ?tr "nada") then
		(printout t ?n " " ?a " que tiene un presupuesto de " ?f ", aunque siempre puedes optar por otras opciones, se te recomienda: caminar" crlf)
	else
		(printout t ?n " " ?a " que tiene un presupuesto de " ?f ", se te recomienda transportarte con: " ?tr "; si es posible, puedes conseguir este transporte: " ?vr crlf)	
	)
)






