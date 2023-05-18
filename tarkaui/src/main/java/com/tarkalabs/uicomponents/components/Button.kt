
    SECONDARY -> {
      ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.secondary,
        contentColor = MaterialTheme.colorScheme.onSecondary
      )
    }

    GHOST -> {
      ButtonDefaults.buttonColors(
        containerColor = Color.Transparent, contentColor = MaterialTheme.colorScheme.secondary
      )
    }

    ERROR -> {
      ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.error,
        contentColor = MaterialTheme.colorScheme.onPrimary,
      )
    }

    OUTLINE -> {
      ButtonDefaults.buttonColors(
        containerColor = MaterialTheme.colorScheme.surface,
        contentColor = MaterialTheme.colorScheme.onSurface
      )
    }
  }
  Button(
    onClick = onClick,
    colors = buttonColor,
    modifier = Modifier
      .height(height.size)
      .wrapContentWidth(),
    contentPadding = height.paddingValues(leadingIcon == null, trailingIcon == null),
    border = if (buttonStyle == OUTLINE) BorderStroke(
      width = 1.dp, color = MaterialTheme.colorScheme.onSurface
    ) else null
  ) {
    Row(
      verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.Center
    ) {
      leadingIcon?.let {
        Icon(
          painter = painterResource(id = leadingIcon.iconRes),
          contentDescription = leadingIcon.contentDescription,
          modifier = Modifier.size(height.iconSize())
        )
      }
      Text(text = label, style = height.textStyle())
      trailingIcon?.let {
        Icon(
          painter = painterResource(id = trailingIcon.iconRes),
          contentDescription = trailingIcon.contentDescription,
          modifier = Modifier.size(height.iconSize())
        )
      }
    }
  }
}

@Composable @Preview(showBackground = true, showSystemUi = true) fun PreviewPrimaryButton() {
  EamTheme {
    Column(
      horizontalAlignment = Alignment.CenterHorizontally,
      modifier = Modifier
        .fillMaxSize()
        .verticalScroll(rememberScrollState())
    ) {
      Row(horizontalArrangement = Arrangement.SpaceBetween) {
        Column {
          Text("Primary Button", fontSize = 24.sp)
          Spacer(modifier = Modifier.height(20.dp))
          TKButton(label = "Primary ", height = M, buttonStyle = PRIMARY, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Primary ", height = L, buttonStyle = PRIMARY, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Primary ", height = S, buttonStyle = PRIMARY, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Primary ", height = XS, buttonStyle = PRIMARY, onClick = {})

        }
        Column {
          Text("Secondary Button", fontSize = 24.sp)
          Spacer(modifier = Modifier.height(20.dp))
          TKButton(label = "Secondary ", height = M, buttonStyle = SECONDARY, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Secondary ", height = L, buttonStyle = SECONDARY, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Secondary ", height = S, buttonStyle = SECONDARY, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Secondary ", height = XS, buttonStyle = SECONDARY, onClick = {})
        }
      }

      Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
          .fillMaxWidth()
          .padding(horizontal = 10.dp)
      ) {
        Column(horizontalAlignment = Alignment.Start) {
          Text("Ghost Button", fontSize = 24.sp)
          Spacer(modifier = Modifier.height(20.dp))
          TKButton(label = "Ghost Button", height = M, buttonStyle = GHOST, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Ghost Button", height = L, buttonStyle = GHOST, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Ghost Button", height = S, buttonStyle = GHOST, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Ghost Button", height = XS, buttonStyle = GHOST, onClick = {})
        }

        Column {
          Text("Error Button", fontSize = 24.sp)
          Spacer(modifier = Modifier.height(20.dp))
          TKButton(label = "Error Button", height = M, buttonStyle = ERROR, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Error Button", height = L, buttonStyle = ERROR, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Error Button", height = S, buttonStyle = ERROR, onClick = {})
          Spacer(modifier = Modifier.height(10.dp))
          TKButton(label = "Error Button", height = XS, buttonStyle = ERROR, onClick = {})

        }
      }
      Text("Outline Button", fontSize = 30.sp)
      Spacer(modifier = Modifier.height(20.dp))
      TKButton(label = "Outline Button", height = M, buttonStyle = OUTLINE, onClick = {})
      Spacer(modifier = Modifier.height(10.dp))
      TKButton(label = "Outline Button", height = L, buttonStyle = OUTLINE, onClick = {})
      Spacer(modifier = Modifier.height(10.dp))
      TKButton(label = "Outline Button", height = S, buttonStyle = OUTLINE, onClick = {})
      Spacer(modifier = Modifier.height(10.dp))
      TKButton(label = "Outline Button", height = XS, buttonStyle = OUTLINE, onClick = {})
    }
  }
}