# MemoryPalace Application

## Overview

## How to Run
TODO: LINK TO DEPLOYED APP, LOGIN INFO IF NEEDED

## REST API

| HTTP Method | Resource URI | Request Body |       Returns       |
|------------|--------------|--------------|--------------------|
| GET         |`api/users/{userId}/rooms`|Lists all rooms for user|List&lt;Room&gt;|
|------------|--------------|--------------|--------------------|
| GET         |`api/rooms/{roomId}/items`|Lists all items in room for user|List&lt;Item&gt;|
|------------|--------------|--------------|--------------------|
| POST         |`api/rooms/{roomId}/items`|Add a room for user|Room Updated Object|
|------------|--------------|--------------|--------------------|
| POST         |`api/rooms/{roomId}/items`|Add an item to room for user|Item Updated Object|
|------------|--------------|--------------|--------------------|
| DEL         |`api/users/{userId}/rooms/{roomId}`|Delete a room for user|Boolean verifying deletion|
|------------|--------------|--------------|--------------------|
| DEL         |`api/rooms/{roomId}/items/{itemId}`|Delete an item from room for user|Boolean verifying deletion|
|------------|--------------|--------------|--------------------|
*
