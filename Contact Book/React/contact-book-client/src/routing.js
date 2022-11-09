import React from "react"
import { Switch, Route } from "react-router-dom"
import { List, Contact } from "./Pages"

const Router = () => {
	return(
		<Switch>
			<Route exact path={ "/" } component={ List } />
			<Route exact path={ "/contact" } component={ Contact } />
		</Switch>
	)
}

export default Router